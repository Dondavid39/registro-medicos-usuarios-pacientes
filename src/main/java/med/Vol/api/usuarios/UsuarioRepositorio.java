package med.Vol.api.usuarios;

import med.Vol.api.medicos.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio  extends JpaRepository<Usuario, Long> {
}
