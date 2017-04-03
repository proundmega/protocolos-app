package org.proundmega.protocolos.app.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UsuarioRepository {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("vansi").password("vansi").roles("USER").build());
        manager.createUser(User.withUsername("nelson").password("nelson").roles("USER", "ADMIN").build());
        manager.createUser(User.withUsername("roberto").password("roberto").roles("USER").build());
        manager.createUser(User.withUsername("siciliano").password("siciliano").roles("USER").build());
        return manager;
    }
}
