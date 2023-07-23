package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.medicos.*;
import med.Vol.api.usuarios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuariosControlador {
    @Autowired
    private UsuarioRepositorio repositorio;
    @PostMapping //metodo para registrar
    @Transactional
    public void cadastrar(@RequestBody @Valid DatosRegistroUsuarios datos){
//        System.out.println(datos);
        repositorio.save(new Usuario(datos));
    }
// con @PageableDefault podemos alteras las configraciones con las que se guardan los regitros.. el numero(size) de
// registros y la orden(sort) con la que se guardan
    @GetMapping //metodo para enListar
    public Page<listaDatosUsuarios> lista(@PageableDefault(size=100,sort = {"nombre"}) Pageable paginacion) {     //crearemos una lista de forma indirecta(DTO) de medicos y esa lista sera ordenada con la paginacion(Pageable)
        return repositorio.findAll(paginacion).map(listaDatosUsuarios::new) ;
    }

    @PutMapping  // metodo para actualizar
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizaUsuarios datos){
        var usuario = repositorio.getReferenceById(datos.id());
        usuario.actualizaInformaciones(datos);

    }


}
