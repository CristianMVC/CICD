package service;

import com.local.cicd.CICD;
import com.local.cicd.config.CreadorDeObjetos;
import com.local.cicd.dto.UsuarioDto;
import com.local.cicd.entity.Rol;
import com.local.cicd.entity.Usuario;
import com.local.cicd.entity.enums.Roles;
import com.local.cicd.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Usuario
 */
@SpringBootTest(classes = CICD.class)
public class UsuarioServiceTest {

    @Autowired
    UsuarioService usuarioService;

    Usuario usuario;

    @BeforeEach
    public void crearUsuarioPrueba() {

        Rol rol = new Rol();
        rol.setNombre(Roles.ROLE_USER);
        rol.setNombre(Roles.ROLE_ADMIN);
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        this.usuario = new Usuario("Prueba2", "Prueba2", roles);

    }

    @Test
    public void crearUsuario() {

      //  ResponseEntity result = usuarioService.insertar(usuario);
      //  assertEquals(result.getClass().getSimpleName(), "UsuarioDto");

    }

}
