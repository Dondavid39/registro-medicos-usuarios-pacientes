package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.dominio.medicos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")

public class MedicosControlador {
    @Autowired
    private MedicoRepositorio repositorio;
    @PostMapping //metodo para registrar
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DatosRegistroMedicos datos, UriComponentsBuilder uriCreador){
        var medico =new Medico(datos);
        repositorio.save(new Medico(datos));
        var uri = uriCreador.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();


        return ResponseEntity.created(uri).body(new DatosDetalladosMedico(medico));
    }
// con @PageableDefault podemos alteras las configraciones con las que se guardan los regitros.. el numero(size) de
// registros y la orden(sort) con la que se guardan
    @GetMapping //metodo para enListar
    public ResponseEntity<Page<listaDatosMedicos>> lista(@PageableDefault(size=100,sort = {"nombre"}) Pageable paginacion) {     //crearemos una lista de forma indirecta(DTO) de medicos y esa lista sera ordenada con la paginacion(Pageable)
        var page =  repositorio.findAllByActivoTrue(paginacion).map(listaDatosMedicos::new) ;
        return  ResponseEntity.ok(page);
    }

    @PutMapping  // metodo para actualizar
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizaMedicos datos){
        var medico = repositorio.getReferenceById(datos.id());
        medico.actualizaInformaciones(datos);
        return  ResponseEntity.ok(new DatosDetalladosMedico(medico));
        // return  ResponseEntity.ok(medico);  --- no se recomienda vincular directamente la clase con la requesicion por
        // medidas de seguridad.. se recomienda vincularla de forma indirecta a travez de un DTO o una clase que de
        // accceso a la clase a ser consultada ---
    }

    //    --- metodo para borrar un medico del banco de datos ---
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void Borrar(@PathVariable long id) {
//        repositorio.deleteById(id);

 //   --- metodo para en vez de borrar dejar como activo o no un medico en el banco de datos ---
        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity Borrar(@PathVariable long id) {
            var medico = repositorio.getReferenceById(id);
            medico.borrar();

            return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detallar(@PathVariable long id) {
        var medico = repositorio.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalladosMedico(medico));
    }
}
