package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.dominio.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")

public class PacientesControlador {
    @Autowired
    private PacienteRepositorio repositorio;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DatosRegistroPacientes datos, UriComponentsBuilder uriCreado) {
        var paciente = new Paciente(datos);
        repositorio.save(paciente);
        var uri = uriCreado.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalladosPaciente(paciente));

    }
    @GetMapping
    public ResponseEntity<Page<ListaDatosPacientes>> listar(@PageableDefault(size = 100, sort = {"nombre"}) Pageable paginacion) {
        var page = repositorio.findAllByActivoTrue(paginacion).map(ListaDatosPacientes::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizaPacientes dados) {
        var paciente = repositorio.getReferenceById(dados.id());
        paciente.atualizarInformaciones(dados);

        return ResponseEntity.ok(new DatosDetalladosPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrar(@PathVariable Long id) {
        var paciente = repositorio.getReferenceById(id);
        paciente.borrar();

        return ResponseEntity.noContent().build();
    }
}
