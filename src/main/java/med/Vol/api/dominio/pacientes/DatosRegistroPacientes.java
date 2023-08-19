package med.Vol.api.dominio.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.Vol.api.dominio.direccion.DatosDireccion;

public record DatosRegistroPacientes(
        @NotBlank //le estoy diciendo al programa que mi atributo no puede ser nulo ni vacio, tiene que ser preenchido
        String nombre,
        @NotBlank
        @Email  //el atributo tiene que ser en formato de correo Electronico
        String correo,
        @NotBlank
        String telefono,
        @NotNull
        @Valid //valida la enfermedad
        String enfermedad,

        @NotNull
        @Valid //valida el objeto DatosDireccion
        DatosDireccion direccion ) {
}
