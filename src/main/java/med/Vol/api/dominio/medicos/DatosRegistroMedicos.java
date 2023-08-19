package med.Vol.api.dominio.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.Vol.api.dominio.direccion.DatosDireccion;

public record DatosRegistroMedicos(


        @NotBlank (message = "Nome é obrigatório")//le estoy diciendo al programa que mi atributo no puede ser nulo ni vacio, tiene que ser preenchido
        String nombre,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido") //el atributo tiene que ser en formato de correo Electronico
        String correo,
        @NotBlank(message = "Telefone é obrigatório")
        String telefono,
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")// para el siguiente atributo el Patron tiene que ser de 4 a 6 Digitos
        String crm,
        @NotNull(message = "Especialidade é obrigatória")// el atributo no puede ser nulo
        Especialidad especialidad,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid //valida el objeto DatosDireccion
        DatosDireccion direccion) {
}
