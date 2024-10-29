package co.edu.usco.parcial2.app.service;

import co.edu.usco.parcial2.app.entity.UserEntity;

import java.util.List;
import java.util.Set;

public interface IUserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Integer id);
    UserEntity findUserByUserName(String userName);
    void deleteUser(Integer id);
    void saveUser(UserEntity user, Set<Integer> roleIds);

}
