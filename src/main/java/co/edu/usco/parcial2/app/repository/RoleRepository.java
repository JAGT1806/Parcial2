package co.edu.usco.parcial2.app.repository;

import co.edu.usco.parcial2.app.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
