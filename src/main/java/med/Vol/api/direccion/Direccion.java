package med.Vol.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter                     //forma de generar automaticamente los getters de la clase
@NoArgsConstructor          //forma de generar los consstructores sin argumento(default) que o JPA exige, de la clase
@AllArgsConstructor         //forma de generar los consstructores que reciben todos los campos de la clase
public class Direccion {
    private String logradouro;
    private String barrio;
    private String cep;
    private String ciudad;
    private String estado;
    private String complemento;
    private String numero;

    public Direccion(DatosDireccion datos) {
        this.barrio=datos.barrio();
        this.cep=datos.cep();
        this.estado = datos.estado();
        this.ciudad=datos.ciudad();
        this.complemento= datos.complemento();
        this.logradouro= datos.logradouro();
        this.numero= datos.numero();
    }

    public void actualizacionInformacion(DatosDireccion datos) {
        if(datos.logradouro() != null){ // si el recurso logradouro fuera actualiado se Renombrara
            this.logradouro = datos.logradouro();
        }
        if(datos.barrio() != null){
            this.barrio = datos.barrio();
        }
        if(datos.cep() != null){
            this.cep = datos.cep();
        }
        if(datos.estado() != null){
            this.estado = datos.estado();
        }
        if(datos.numero() != null){
            this.numero = datos.numero();
        }
        if(datos.ciudad() != null){
            this.ciudad = datos.ciudad();
        }
        if(datos.complemento() != null){
            this.complemento = datos.complemento();
        }
    }
}
