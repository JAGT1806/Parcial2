package co.edu.usco.parcial2.app.repository;

import co.edu.usco.parcial2.app.entity.ClasesEntity;
import co.edu.usco.parcial2.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClasesRepository extends JpaRepository<ClasesEntity, Integer> {
    Optional<List<ClasesEntity>> findByProfesor(UserEntity user);
}
