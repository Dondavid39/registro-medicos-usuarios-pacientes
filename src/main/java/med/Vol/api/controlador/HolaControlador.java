package med.Vol.api.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")

public class HolaControlador {

    @GetMapping
    public String holaMundo(){
        return  "hola gente, mucho gusto";
    }

}
