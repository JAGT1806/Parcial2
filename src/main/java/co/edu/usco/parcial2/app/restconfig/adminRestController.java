package co.edu.usco.parcial2.app.restconfig;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class adminRestController {
    // Llamar servicio principal


    @Operation(summary = "Añadir")
    @PostMapping("/add")
    public ResponseEntity<?> save (
            @Parameter(description = "Datos básicos para insertar estancia de vehículo")
            @RequestBody String hola) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar todos los vehículos")
    @GetMapping("/find")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar vehículo")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

}
