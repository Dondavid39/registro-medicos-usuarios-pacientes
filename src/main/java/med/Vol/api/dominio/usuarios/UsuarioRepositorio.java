package med.Vol.api.dominio.usuarios;

import io.micrometer.observation.ObservationFilter;
import med.Vol.api.dominio.pacientes.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio  extends JpaRepository<Usuario, Long>{

    UserDetails findByLogin(String username);

    Page<Usuario> findAllByActivoTrue(Pageable paginacion);
}
