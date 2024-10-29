package co.edu.usco.parcial2.app.service;

import co.edu.usco.parcial2.app.entity.RoleEntity;
import co.edu.usco.parcial2.app.entity.UserEntity;
import co.edu.usco.parcial2.app.service.imp.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }


    private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (RoleEntity role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, authorities);
    }
}
