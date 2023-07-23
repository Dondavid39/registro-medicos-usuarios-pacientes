package med.Vol.api.medicos;

public record listaDatosMedicos(Long id, String nombre, String correo, String crm, Especialidad especialidad) {
    public listaDatosMedicos(Medico doctor){
        this(doctor.getId(), doctor.getNombre(), doctor.getCorreo(), doctor.getCrm(), doctor.getEspecialidad());
    }
}
