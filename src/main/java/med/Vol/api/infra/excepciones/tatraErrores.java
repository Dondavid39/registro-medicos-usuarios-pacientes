package med.Vol.api.infra.excepciones;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class tatraErrores {

    @ExceptionHandler(EntityNotFoundException.class) // simepre que aparezca esse error EntityNotFoundException.class
                                                        // se aplicara el metodo siguiente
    public ResponseEntity trataError404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // se aplicara el metodo siguiente
    public ResponseEntity trataError400(MethodArgumentNotValidException ex){
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DatosValidacionErrores::new).toList());
    }

    private record DatosValidacionErrores(String campo, String mensaje){
        public DatosValidacionErrores(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

