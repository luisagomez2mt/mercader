/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo4.mercaderR1C4.app.services;

import co.usa.ciclo4.mercaderR1C4.app.entities.User;
import co.usa.ciclo4.mercaderR1C4.app.repositories2.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luigi
 */

@Service

public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (verificarEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean verificarEmail(String email) {
        return userRepository.verificarEmail(email);
    }

    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();

        } else {
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setName("NO DEFINIDO");

            return u;
        }
    }
/**
 * 
 * @param user
 * @return 
    public User save(User user) {
        return userRepository.save(user);
    }
    
 */
 
    public boolean getByEmail(String email ){
        Optional<User> user= userRepository.getByEmail(email);
        if(user.isPresent()){
            return true;
        }else{
            return false;
        }
    }

}
