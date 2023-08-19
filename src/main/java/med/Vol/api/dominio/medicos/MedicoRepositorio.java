package med.Vol.api.dominio.medicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//      a JpaRepository hay que poasarle los Genericos, Mayor que Menor que.. hay que pasarlos dos tipos de Objetos,
//      cual es el tipo de Clase, de Entidad que va a trabaja(Medico) y el otro es el  tipo de atributo de la llave
//                         primaria(Long), o sea si es String, Double, Int, etc
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByActivoTrue(Pageable paginacion);
}
