package med.Vol.api.dominio.pacientes;

import med.Vol.api.dominio.direccion.Direccion;


public record DatosDetalladosPaciente( Long id, String nombre, String correo, String telefono,  Direccion direccion) {

    public DatosDetalladosPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNombre(), paciente.getCorreo(), paciente.getTelefono(),  paciente.getDireccion());
    }

}