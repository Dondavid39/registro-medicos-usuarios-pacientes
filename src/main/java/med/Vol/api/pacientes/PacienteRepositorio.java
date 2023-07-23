package med.Vol.api.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;
//      a JpaRepository hay que poasarle los Genericos, Mayor que Menor que.. hay que pasarlos dos tipos de Objetos,
//      cual es el tipo de Clase, de Entidad que va a trabaja(Medico) y el otro es el  tipo de atributo de la llave
//                         primaria(Long), o sea si es String, Double, Int, etc
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
}
