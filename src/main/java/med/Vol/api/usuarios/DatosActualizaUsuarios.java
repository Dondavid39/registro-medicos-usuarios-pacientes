package med.Vol.api.usuarios;

import jakarta.validation.constraints.NotNull;
import med.Vol.api.direccion.DatosDireccion;

public record DatosActualizaUsuarios(
        boolean admin,
        @NotNull // colocaremos solo el Id como informacion necesaria para la actualizacion
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion ) {
}

