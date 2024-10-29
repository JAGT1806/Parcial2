package co.edu.usco.parcial2.app.repository;

import co.edu.usco.parcial2.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM UserEntity u JOIN u.role r WHERE r.role = ?1")
    Optional<List<UserEntity>> findByRole(String roleName);

    boolean existsByUsername(String username);
}
