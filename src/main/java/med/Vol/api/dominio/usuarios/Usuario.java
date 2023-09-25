package med.Vol.api.dominio.usuarios;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.Vol.api.dominio.direccion.Direccion;
import med.Vol.api.dominio.pacientes.DatosActualizaPacientes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Usuario")
@Table(name = "usuarios")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(name = "acceso")
    private String login;

   // @Column(name = "contrasena") //manera de darle a entender que la palabra "contraseña" significa que es el recurso password
    private String password;

    private boolean activo;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {   //aqui uno explica para o Xpring que solo hay un tipo de usuario(role)
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); 
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login    ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario(DatosRegistroUsuarios datos) {

        this.login = datos.login();
        this.password = datos.password();
    }
    public void atualizarInformaciones(DatosActualizaUsuarios datos) {
        if (datos.login() != null) { // si el recurso nombre fuera actualiado se Renombrara
            this.login = datos.login();
        }
        if (datos.password() != null) {
            this.password = datos.password();
        }
}
    public void borrar() {
        this.activo = false;
    }
}