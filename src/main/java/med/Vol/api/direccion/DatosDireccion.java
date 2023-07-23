package med.Vol.api.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosDireccion(
        @NotBlank
        String logradouro,
        @NotBlank
        String barrio,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // el atributo tiene que tener 8 Digitos
        String cep,
        @NotBlank
        String ciudad,
        @NotBlank
        String estado,
        //los atributos complementos y numero son opcionales
        String complemento,
        String numero){
}
