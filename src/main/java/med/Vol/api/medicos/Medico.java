package med.Vol.api.medicos;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Vol.api.direccion.Direccion;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Table(name = "medicos")    //con eso estoy diciendo que en el banco de datos hay una tabela llamada "medicos"
@Entity(name = "Medico")

@Getter                     //forma de generar automaticamente los getters de la clase
@NoArgsConstructor          //forma de generar los consstructores sin argumento(default) que o JPA exige, de la clase
@AllArgsConstructor         //forma de generar los consstructores que reciben todos los campos de la clase
@EqualsAndHashCode(of="id") // para generar los HasCode encima del id, no encima de todos los atributos

public class Medico {
    @Id @GeneratedValue(  strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
    private boolean activo;

    public Medico(DatosRegistroMedicos datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.crm = datos.crm();
        this.telefono= datos.telefono();
        this.especialidad= datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizaInformaciones(DatosActualizaMedicos datos) {
        if(datos.nombre() != null){ // si el recurso nombre fuera actualiado se Renombrara
            this.nombre = datos.nombre();
        }
        if(datos.telefono() != null){
            this.telefono = datos.telefono();
        }
        // por el hecho de Direccion ser una clase y no un recurso, tenemos que crear
        // un metodo que altere el recurso de esa clase
        if(datos.direccion() != null){
            this.direccion.actualizacionInformacion(datos.direccion());
        }
    }

    public void borrar() {
        this.activo=false;
    }
}
