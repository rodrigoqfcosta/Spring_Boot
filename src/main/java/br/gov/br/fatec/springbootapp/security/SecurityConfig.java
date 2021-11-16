package br.gov.br.fatec.springbootapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity // Configurações de segurança padrão
@EnableGlobalMethodSecurity(prePostEnabled = true) // Habilitando segurança por @notação
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService; // Serviço para busca de usuario

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // O metodo de segurança CSRF(), faz com que a pagina web ao receber um token, o Spring-Security retorna o token como resposta
        http.csrf().disable()
        // Adicionar o filtro de requisições Antes da inicialização do Spring-security
        .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class) 
        // Modo STATELESS, não guarda as informações segurança realizando o logout
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Buscando dados do usuario no banco de dados
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
    }
    
    // Configuração do hash - BCrypt
    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
