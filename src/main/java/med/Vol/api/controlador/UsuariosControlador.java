package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.dominio.pacientes.DatosActualizaPacientes;
import med.Vol.api.dominio.pacientes.DatosDetalladosPaciente;
import med.Vol.api.dominio.pacientes.ListaDatosPacientes;
import med.Vol.api.dominio.pacientes.Paciente;
import med.Vol.api.dominio.usuarios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")

public class UsuariosControlador {
    @Autowired
    private UsuarioRepositorio repositorio;
    @PostMapping //metodo para registrar
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DatosRegistroUsuarios info, UriComponentsBuilder uriCreado){
        var usuario = new Usuario(info);
        repositorio.save(usuario);
        var uri = uriCreado.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalladosUsuarios(usuario));

    }
    @GetMapping
    public ResponseEntity<Page<ListaDatosUsuarios>> listar(@PageableDefault(size = 100, sort = {"login"}) Pageable paginacion) {
        var page = repositorio.findAllByActivoTrue(paginacion).map(ListaDatosUsuarios::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizaUsuarios dados) {
        var usuario = repositorio.getReferenceById(dados.id());
        usuario.atualizarInformaciones(dados);

        return ResponseEntity.ok(new DatosDetalladosUsuarios(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrar(@PathVariable Long id) {
        var usuario = repositorio.getReferenceById(id);
        usuario.borrar();

        return ResponseEntity.noContent().build();
    }
}
