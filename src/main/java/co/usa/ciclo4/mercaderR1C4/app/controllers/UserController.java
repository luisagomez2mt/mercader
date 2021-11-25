/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo4.mercaderR1C4.app.controllers;

import co.usa.ciclo4.mercaderR1C4.app.entities.User;
import co.usa.ciclo4.mercaderR1C4.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luigi
 */

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")

public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * Recuperar todos los usuarios
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getUser() {
        return userService.getAll();
    }
    //Registrar usuario

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }

    //autentica usuario con email y password
    @GetMapping("/{email}/{password}")
    private User getByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return userService.getByEmailAndPassword(email, password);
    }

    //autentica email solo
    @GetMapping("/{email}")
    public boolean verificarEmail(@PathVariable("email") String email) {
        return userService.getByEmail(email);
    }

}
