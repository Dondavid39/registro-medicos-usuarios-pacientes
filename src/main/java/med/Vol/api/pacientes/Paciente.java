package med.Vol.api.pacientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Vol.api.direccion.Direccion;

@Table(name = "pacientes")    //con eso estoy diciendo que en el banco de datos hay una tabela llamada "medicos"
@Entity(name = "Paciente")

@Getter                     //forma de generar automaticamente los getters de la clase
@NoArgsConstructor          //forma de generar los consstructores sin argumento(default) que o JPA exige, de la clase
@AllArgsConstructor         //forma de generar los consstructores que reciben todos los campos de la clase
@EqualsAndHashCode(of="id") // para generar los HasCode encima del id, no encima de todos los atributos
public class Paciente {
    @Id @GeneratedValue(  strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String enfermedad;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPacientes datos) {
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.enfermedad = datos.enfermedad();
        this.telefono= datos.telefono();
        this.direccion = new Direccion(datos.direccion());
    }
}
