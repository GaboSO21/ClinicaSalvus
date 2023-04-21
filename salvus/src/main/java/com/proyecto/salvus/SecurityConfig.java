
package com.proyecto.salvus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        // @Bean
        // public UserDetailsService users() {
        // UserDetails admin = User.builder()
        // .username("Juan")
        // .password("{noop}Juan123")
        // .roles("USER", "ADMIN")
        // .build();
        // UserDetails sales = User.builder()
        // .username("Rebeca")
        // .password("{noop}Rebeca123")
        // .roles("USER")
        // .build();
        // UserDetails user = User.builder()
        // .username("Pedro")
        // .password("{noop}Pedro123")
        // .roles("USER")
        // .build();
        //
        // return new InMemoryUserDetailsManager(user, sales, admin);
        // }

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
                                                "/index",
                                                "/admin",
                                                "/admin/**")
                                .permitAll()
                                .requestMatchers("/contacto")
                                .hasAnyRole("ADMIN"))
                                // .requestMatchers(
                                // "/cliente/eliminar/**")
                                // .hasRole("ADMIN"))
                                // .requestMatchers(
                                // "/articulo/listado",
                                // "/categoria/listado",
                                // "/cliente/listado")
                                // .hasRole("USER"))
                                .formLogin((form) -> form
                                                .passwordParameter("contrasenna")
                                                .usernameParameter("username")
                                                .defaultSuccessUrl("/", true)
                                                .loginPage("/login").permitAll())
                                .logout((logout) -> logout.permitAll());
                return http.build();
        }

}
