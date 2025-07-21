package com.local.cicd;

import com.local.cicd.config.CreadorDeObjetos;
import com.local.cicd.entity.Rol;
import com.local.cicd.entity.Usuario;
import com.local.cicd.entity.enums.Roles;
import com.local.cicd.repository.RolRepository;
import com.local.cicd.repository.UsuarioRepository;
import com.local.cicd.service.UsuarioService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class DataInit implements CommandLineRunner {

    private final UsuarioRepository usuarioRepositorio;
    private final RolRepository rolRepository;
    private final CreadorDeObjetos creadorDeObjetos;

    @Autowired
    PasswordEncoder encoder;

    public DataInit(UsuarioRepository repositorio, RolRepository rolRepository) {
        this.usuarioRepositorio = repositorio;
        this.creadorDeObjetos = new CreadorDeObjetos();
        this.rolRepository = rolRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(Roles.values()).forEach(roles
                -> {
            rolRepository.save(new Rol(roles));
        });

        Rol rol = rolRepository.findByNombre(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Rol ROLE_USER no encontrado"));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);

        String password = encoder.encode("prueba");
        usuarioRepositorio.save(new Usuario("prueba", password, roles));
        registrarClases(UsuarioService.class);

    }

    private void registrarClases(Class clase) {
        creadorDeObjetos.registrar(clase);
    }

}
