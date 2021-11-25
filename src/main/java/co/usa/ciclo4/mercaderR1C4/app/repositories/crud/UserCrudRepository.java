/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo4.mercaderR1C4.app.repositories.crud;

import co.usa.ciclo4.mercaderR1C4.app.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luigi
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    
     //  @Query("select u from User u where u.email = ?1 and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);

 //   @Query( "select user from User user where user.email =?1")
    Optional<User> findByEmail(String email);

}
