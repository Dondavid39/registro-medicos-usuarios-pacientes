package med.Vol.api.usuarios;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.Vol.api.direccion.Direccion;
import med.Vol.api.medicos.DatosActualizaMedicos;
import med.Vol.api.medicos.DatosRegistroMedicos;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Usuario")
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private Boolean admin = false;  // para que todo nuevo usuario no sea necesariamente un administrador
    @Embedded
    private Direccion direccion;

    public Usuario (DatosRegistroUsuarios datos) {
        this.admin = false;
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.telefono = datos.telefono();
        this.direccion = new Direccion(datos.direccion()
        );
    }

    public void actualizaInformaciones(DatosActualizaUsuarios datos) {
            if(datos.nombre() != null){ // si el recurso nombre fuera actualiado se Renombrara
                this.nombre = datos.nombre();
            }
            if(datos.telefono() != null){
                this.telefono = datos.telefono();
            }
            if(datos.admin() != true){
                this.admin= Boolean.FALSE;
            }
            // por el hecho de Direccion ser una clase y no un recurso, tenemos que crear
            // un metodo que altere el recurso de esa clase
            if(datos.direccion() != null){
                this.direccion.actualizacionInformacion(datos.direccion());
            }
        }


}