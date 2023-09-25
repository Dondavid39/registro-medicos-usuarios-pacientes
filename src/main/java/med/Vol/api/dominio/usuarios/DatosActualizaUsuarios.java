package med.Vol.api.dominio.usuarios;

import jakarta.validation.constraints.NotNull;
import med.Vol.api.dominio.direccion.DatosDireccion;

public record DatosActualizaUsuarios(
//        @NotNull
//        boolean admin,
        @NotNull // colocaremos solo el Id como informacion necesaria para la actualizacion
        Long id,
        String password,
        String login
//        String telefono,
//        DatosDireccion direccion
) {
}

