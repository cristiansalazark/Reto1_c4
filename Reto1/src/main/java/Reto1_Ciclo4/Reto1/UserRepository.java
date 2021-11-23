
package Reto1_Ciclo4.Reto1;
/**
 * <h1>Repository </h1>
 * Clase userRepository  crea los metodos para traer y enviar la informacion
 * @since 23-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
   
     @Autowired
    private UserCrudRepository userCrudRepository;
     /**
      * obtiene la lista 
      * @return 
      */
     public List <User> getAll(){
     return (List<User>) userCrudRepository.findAll();
     }
     /**
      * obtiene los parametros por  id
      * @param id
      * @return 
      */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
       /**
        * guarda el usuario
        * @param user
        * @return 
        */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
   /**
    * verifica la existrencia de email
    * @param email
    * @return retorna si hay existencia 
    */
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    /**
     * verifica la autentificaion de usuario
     * @param email
     * @param password
     * @return retorna la autentificacion
     */
     public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
     
}
