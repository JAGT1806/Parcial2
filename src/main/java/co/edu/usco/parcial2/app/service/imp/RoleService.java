package co.edu.usco.parcial2.app.service.imp;

import co.edu.usco.parcial2.app.entity.RoleEntity;
import co.edu.usco.parcial2.app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Set<RoleEntity> getAllRoles() {
        List<RoleEntity> roles = roleRepository.findAll();
        return new HashSet<>(roles);
    }

    public void saveRole(RoleEntity role) {
        roleRepository.save(role);
    }
}
