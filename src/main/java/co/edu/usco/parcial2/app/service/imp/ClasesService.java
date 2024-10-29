package co.edu.usco.parcial2.app.service.imp;

import co.edu.usco.parcial2.app.entity.ClasesEntity;
import co.edu.usco.parcial2.app.entity.UserEntity;
import co.edu.usco.parcial2.app.repository.ClasesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClasesService {
    private final ClasesRepository clasesRepository;

    public List<ClasesEntity> getAllClases(){
        return clasesRepository.findAll();
    }

    public List<ClasesEntity> getAllClasesByDocente(UserEntity docente){
        return clasesRepository.findByProfesor(docente).orElse(new ArrayList<>());
    }

    public ClasesEntity getClaseById(Integer id){
        return clasesRepository.findById(id).orElse(null);
    }

    public void saveClase(ClasesEntity clase){
        clasesRepository.save(clase);
    }

    public void editClase(ClasesEntity clase){
        clasesRepository.save(clase);
    }

    public void deleteClase(Integer id){
        clasesRepository.deleteById(id);
    }

}
