package com.derek.nasa_social_media_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.derek.nasa_social_media_app.component.UserProfileService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


@Autowired
private UserProfileService userProfileService;
 
 
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                registry.requestMatchers("/home/","/names","/register/**")
                .permitAll();
                registry.anyRequest().authenticated();

            })
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            .build();
                
}

  @Bean
    public UserProfileService myUserProfileService() {
        return userProfileService;
    }

 @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userProfileService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
