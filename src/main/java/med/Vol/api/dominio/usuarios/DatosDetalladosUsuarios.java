package med.Vol.api.dominio.usuarios;

public record DatosDetalladosUsuarios(Long id, String password, String login) {
    public DatosDetalladosUsuarios(Usuario usuario){
        this( usuario.getId(), usuario.getLogin(), usuario.getPassword());
    }}