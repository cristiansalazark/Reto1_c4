
package Reto1_Ciclo4.Reto1;
/**
 * <h1>User </h1>
 * Clase usuario crea la tabla usuario con sus condiciones de caracteres propios de cada variable
 * @since 23-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;




@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {
     /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * definicion de variables de la tabla user y se asignan complementos a las columnas con @colum
     */
    private Integer id;
      @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name; 
        
}
