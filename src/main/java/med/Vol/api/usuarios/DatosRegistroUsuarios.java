package med.Vol.api.usuarios;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.Vol.api.direccion.DatosDireccion;
import med.Vol.api.medicos.Especialidad;

public record DatosRegistroUsuarios(
        @NotBlank //le estoy diciendo al programa que mi atributo no puede ser nulo ni vacio, tiene que ser preenchido
        String nombre,
        @NotBlank
        @Email  //el atributo tiene que ser en formato de correo Electronico
        String correo,
        @NotBlank
        String telefono,

        @NotNull
        @Valid //valida el objeto DatosDireccion
        DatosDireccion direccion
) {
}
