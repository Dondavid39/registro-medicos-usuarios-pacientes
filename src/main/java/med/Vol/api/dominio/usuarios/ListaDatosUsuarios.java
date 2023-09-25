package med.Vol.api.dominio.usuarios;

public record ListaDatosUsuarios(Long id, String password, String login) {
    public ListaDatosUsuarios(Usuario usuario){
        this( usuario.getId(), usuario.getLogin(), usuario.getPassword());
    }
}