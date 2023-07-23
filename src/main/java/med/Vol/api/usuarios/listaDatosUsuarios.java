package med.Vol.api.usuarios;

import med.Vol.api.medicos.Especialidad;
import med.Vol.api.medicos.Medico;

public record listaDatosUsuarios(Long id, String nombre, String correo, String telefono) {
    public listaDatosUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getTelefono());
    }
}

