package proyecto.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import proyecto.backend.dto.PeticionLogin;
import proyecto.backend.dto.Usuario;
import proyecto.backend.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
/*
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/
    public boolean validarCredenciales(PeticionLogin body) {
    	System.out.print(body.username);
    	System.out.print(body.password);
        Usuario usuario = usuarioRepositorio.findByUser(body.getUsername());
        return usuario != null && body.getPassword().matches(usuario.getPwd());
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
