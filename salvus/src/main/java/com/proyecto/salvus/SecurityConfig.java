
package com.proyecto.salvus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
                build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(5));
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http)
                        throws Exception {
                http.authorizeHttpRequests((request) -> request
                                .requestMatchers("/",
                                                "/doctores/listado",
                                                "/servicios/listado",
                                                "/imgs/**",
                                                "/styles/**",
                                                "/webjars/**",
                                                "/contacto",
                                                "/contacto/enviar",
                                                "/index")
                                .permitAll()
                                .requestMatchers("/admin",
                                                "/admin/**",
                                                "/doctores/guardar",
                                                "/doctores/eliminar/**",
                                                "/doctores/editar/**",
                                                "/servicios/guardar",
                                                "/servicios/eliminar/**",
                                                "/servicios/editar/**",
                                                "/signos/guardar",
                                                "/signos/editar/**",
                                                "/diagnostico/guardar",
                                                "/diagnostico/editar/**",
                                                "/expediente/guardar",
                                                "/expediente/editar/**",
                                                "/pacientes/guardar",
                                                "/pacientes/editar/**",
                                                "/pacientes/eliminar/**",
                                                "/usuario/guardar",
                                                "/usuario/eliminar/**",
                                                "/usuario/editar/**",
                                                "/contacto/enviar/pacientes"
                                                )
                                .hasRole("ADMIN")
                                .requestMatchers(
                                                "/usuario")
                                .hasAnyRole("ADMIN", "USER"))
                                .formLogin((form) -> form
                                                .passwordParameter("contrasenna")
                                                .usernameParameter("username")
                                                .defaultSuccessUrl("/", true)
                                                .loginPage("/login").permitAll())
                                .logout((logout) -> logout
                                                .logoutSuccessUrl("/")
                                                .permitAll())
                                .exceptionHandling(handling -> handling
                                                .accessDeniedPage("/errores/403"));
                return http.build();
        }

}
