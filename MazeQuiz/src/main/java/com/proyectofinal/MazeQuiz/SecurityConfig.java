package com.proyectofinal.MazeQuiz;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 *  Clase que proporciona seguridad a la aplicación web usando la dependencia Spring Security,
 *  bloqueando el acceso a cualquier enlace de la página si no inicia sesión correctamente.
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * Dentro del método se epecifican los valores para la autenticación, que serán procesados por
     * la clase @AuthenticationManagerBuilder
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER");
    }

    /**
     * Dentro del método se especifican las configuraciones adicionales que llevará nuestra seguridad,
     * para este proyecto solo deshabilita la proteccion csrf.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        http.csrf().disable();
    }

}
