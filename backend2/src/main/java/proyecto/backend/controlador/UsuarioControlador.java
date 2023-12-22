package proyecto.backend.controlador;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import proyecto.backend.dto.PeticionLogin;
import proyecto.backend.dto.Usuario;
import proyecto.backend.servicio.UsuarioServicio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@PostMapping(value = "login",consumes = "application/json")
    public String login(@RequestBody PeticionLogin body){
        try {
            Boolean comprobador = usuarioServicio.validarCredenciales(body);
            if(comprobador!= false){
            String token = getJWTToken(body.getUsername());
            return token;
            } 
        }catch (AuthenticationException authExc){
            System.out.print("Esto falla");
        }
        return null;
    }

/*
	@PostMapping("login")
	public Usuario login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		Usuario user = new Usuario();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}
*/
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
