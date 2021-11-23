
package Reto1_Ciclo4.Reto1;
/**
 * <h1>Service </h1>
 * Clase userService  crea los metodos  para registrar usuarios  y  verificar existencias de correo
 * @since 23-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class UserService {
   @Autowired
   private UserRepository userRepository;
   /**
    * obtiene la lista e usuario
    * @return 
    */
   public List<User> getAll(){
       return userRepository.getAll();
   }
   /**
    * obtiene  user
    * @param id
    * @return retorna userRepository
    */
     public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
     
    /**
     * valida user
     * @param user
     * @return retorna validacion de user 
     */
     public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     * valida la existencia de email
     * @param email
     * @return retorna la validacion
     */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
    /**
     * valida  autenficación usuario y password
     * @param email
     * @param password
     * @return retorna autentificación
     */
       public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
    
}
