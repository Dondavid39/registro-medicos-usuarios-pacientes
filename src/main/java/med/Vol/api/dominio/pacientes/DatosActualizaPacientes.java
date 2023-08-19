package med.Vol.api.dominio.pacientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.Vol.api.dominio.direccion.DatosDireccion;

public record DatosActualizaPacientes(
        @NotNull // colocaremos solo el Id como informacion necesaria para la actualizacion
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion ) {
}

