package med.Vol.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Vol.api.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/medicos")

public class MedicosControlador {
    @Autowired
    private MedicoRepositorio repositorio;
    @PostMapping //metodo para registrar
    @Transactional
    public void cadastrar(@RequestBody @Valid DatosRegistroMedicos datos){
//        System.out.println(datos);
        repositorio.save(new Medico(datos));
    }
// con @PageableDefault podemos alteras las configraciones con las que se guardan los regitros.. el numero(size) de
// registros y la orden(sort) con la que se guardan
    @GetMapping //metodo para enListar
    public Page<listaDatosMedicos> lista(@PageableDefault(size=100,sort = {"nombre"}) Pageable paginacion) {     //crearemos una lista de forma indirecta(DTO) de medicos y esa lista sera ordenada con la paginacion(Pageable)
        return repositorio.findAllByActivoTrue(paginacion).map(listaDatosMedicos::new) ;
//        return repositorio.findAll(paginacion).map(listaDatosMedicos::new) ;
    }

    @PutMapping  // metodo para actualizar
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizaMedicos datos){
        var medico = repositorio.getReferenceById(datos.id());
        medico.actualizaInformaciones(datos);
    }

    //    --- metodo para borrar un medico del banco de datos ---
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void Borrar(@PathVariable long id) {
//        repositorio.deleteById(id);

 //   --- metodo para en vez de borrar dejar como activo o no un medico en el banco de datos ---
        @DeleteMapping("/{id}")
        @Transactional
        public void Borrar(@PathVariable long id) {
            var medico = repositorio.getReferenceById(id);
            medico.borrar();
    }
}
