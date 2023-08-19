package med.Vol.api.dominio.medicos;

import jakarta.validation.constraints.NotNull;
import med.Vol.api.dominio.direccion.DatosDireccion;

//colocaremos los recursos que puedan ser actualizados
public record DatosActualizaMedicos(
      @NotNull // colocaremos solo el Id como informacion necesaria para la actualizacion
      Long id,
      String nombre,
      String telefono,
      DatosDireccion direccion ) {
}
