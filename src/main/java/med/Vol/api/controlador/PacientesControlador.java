package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.medicos.DatosRegistroMedicos;
import med.Vol.api.medicos.Medico;
import med.Vol.api.medicos.MedicoRepositorio;
import med.Vol.api.medicos.listaDatosMedicos;
import med.Vol.api.pacientes.DatosRegistroPacientes;
import med.Vol.api.pacientes.ListaDatosPacientes;
import med.Vol.api.pacientes.Paciente;
import med.Vol.api.pacientes.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")

public class PacientesControlador {
    @Autowired
    private PacienteRepositorio repositorio;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DatosRegistroPacientes datos){
//        System.out.println(datos);
        repositorio.save(new Paciente(datos));
    }
// con @PageableDefault podemos alteras las configraciones con las que se guardan los regitros.. el numero(size) de
// registros y la orden(sort) con la que se guardan
    @GetMapping
    public Page<ListaDatosPacientes> lista(@PageableDefault(size=100,sort = {"nombre"}) Pageable paginacion) {     //crearemos una lista de forma indirecta(DTO) de medicos y esa lista sera ordenada con la paginacion(Pageable)
        return repositorio.findAll(paginacion).map(ListaDatosPacientes::new) ;
    }
}
