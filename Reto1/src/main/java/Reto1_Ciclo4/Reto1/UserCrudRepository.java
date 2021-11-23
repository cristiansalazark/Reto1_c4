
package Reto1_Ciclo4.Reto1;
/**
 * <h1>Interface </h1>
 * Clase usercontroller  crea las interfaces
 * @since 23-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserCrudRepository extends CrudRepository <User, Integer> {
    /**
     * interface email
     * @param email
     * @return 
     */
    Optional<User> findByEmail(String email);
    /**
     * interface email y password
     * @param email
     * @param password
     * @return 
     */
    Optional<User> findByEmailAndPassword(String email,String password);
    
}
