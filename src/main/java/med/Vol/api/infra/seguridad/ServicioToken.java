package med.Vol.api.infra.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.Vol.api.dominio.usuarios.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class ServicioToken {

public String generarToken(Usuario usuario){
    try {
        var algoritmo = Algorithm.HMAC256("76543210");
        return JWT.create()
                .withIssuer("API voll.med") //quem esta gerando esse token?
                .withSubject(usuario.getLogin())
                .withExpiresAt(fechaDeExpiracion())
                .sign(algoritmo);
    } catch (JWTCreationException exception){
       throw new RuntimeException("Error al generar el Token JWT", exception);
    }
}
    private Instant fechaDeExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));// el token durara 2h en la zona horaria de Brazil
    }
}
