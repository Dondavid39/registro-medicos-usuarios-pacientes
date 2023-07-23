package med.Vol.api.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.Vol.api.direccion.DatosDireccion;

public record DatosRegistroMedicos(


        @NotBlank //le estoy diciendo al programa que mi atributo no puede ser nulo ni vacio, tiene que ser preenchido
        String nombre,
        @NotBlank
        @Email  //el atributo tiene que ser en formato de correo Electronico
        String correo,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // para el siguiente atributo el Patron tiene que ser de 4 a 6 Digitos
        String crm,
        @NotNull // el atributo no puede ser nulo
        Especialidad especialidad,
        @NotNull
        @Valid //valida el objeto DatosDireccion
        DatosDireccion direccion) {
}
