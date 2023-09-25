package med.Vol.api.dominio.usuarios;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.Vol.api.dominio.direccion.DatosDireccion;


public record DatosRegistroUsuarios(
     //   @NotNull
     //   boolean admin,
       // @NotBlank //le estoy diciendo al programa que mi atributo no puede ser nulo ni vacio, tiene que ser preenchido
        String login,
//        @NotBlank //evita colocar valores repetidos entre otros registros
//        @Email  //el atributo tiene que ser en formato de correo Electronico
//        String correo,
//        @NotBlank
//        String telefono,
//        @NotBlank
//        String acceso,
       // @NotBlank
        String password

//        @NotNull
//        @Valid //valida el objeto DatosDireccion
//        DatosDireccion direccion
) {
}
