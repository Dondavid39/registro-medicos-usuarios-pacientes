package med.Vol.api.dominio.medicos;


import med.Vol.api.dominio.direccion.Direccion;

public record DatosDetalladosMedico(Long id, String nombre, String correo, String telefono, String crm, Especialidad especialidad, Direccion direccion) {

    public DatosDetalladosMedico(Medico medico){
        this(medico.getId(), medico.getNombre(), medico.getCorreo(), medico.getTelefono(), medico.getCrm(), medico.getEspecialidad(), medico.getDireccion());
    }

}
