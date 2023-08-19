package med.Vol.api.controlador;

import jakarta.validation.Valid;
import med.Vol.api.dominio.usuarios.DatosAutenticacion;
import med.Vol.api.dominio.usuarios.Usuario;
import med.Vol.api.infra.seguridad.ServicioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class ControlAutenticacion {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ServicioToken servicioToken;

  @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DatosAutenticacion dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok(servicioToken.generarToken((Usuario) authentication.getPrincipal()));
    }
}
