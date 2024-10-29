package co.edu.usco.parcial2.app.controller;

import co.edu.usco.parcial2.app.entity.ClasesEntity;
import co.edu.usco.parcial2.app.entity.UserEntity;
import co.edu.usco.parcial2.app.service.imp.ClasesService;
import co.edu.usco.parcial2.app.service.imp.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final UserService userService;
    private final ClasesService clasesService;

    // Login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    // Página para cargará ante un acceso denegado
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/home")
    public String list(Model model) {
        UserEntity currentUser = userService.getCurrentSession();
        List<ClasesEntity> clases;

        if(currentUser.getRole().equals("DOCENTE")) {
            clases = clasesService.getAllClasesByDocente(currentUser);
        } else {
            clases = clasesService.getAllClases();
        }
        model.addAttribute("clases", clases);

        return "list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        ClasesEntity clases = new ClasesEntity();
        model.addAttribute("clases", clases);
        List<UserEntity> profesores= userService.getAllProfesores();
        model.addAttribute("profesores", profesores);

        return "new";
    }

    @PostMapping("/newClass")
    public String saveClass(@ModelAttribute("clases") ClasesEntity clases) {
        clasesService.saveClase(clases);
        return "redirect:/home";
    }



    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        ClasesEntity clase = clasesService.getClaseById(id);
        UserEntity currentUser = userService.getCurrentSession();

        // Verificar si el usuario actual es el rector o el profesor asignado a la clase
        if (currentUser.getRole().equals("ESTUDIANTE")) {
            return "redirect:/home";
        }

        // Agregar datos necesarios para la vista
        model.addAttribute("clases", clase);
        List<UserEntity> profesores = userService.getAllProfesores();
        model.addAttribute("profesores", profesores);

        return "edit";
    }

    @PostMapping("/editClass")
    public String editClass(@ModelAttribute("clases") ClasesEntity clases) {
        clasesService.saveClase(clases);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String deleteClass(@PathVariable Integer id) {
        clasesService.deleteClase(id);
        return "redirect:/home";
    }

}
