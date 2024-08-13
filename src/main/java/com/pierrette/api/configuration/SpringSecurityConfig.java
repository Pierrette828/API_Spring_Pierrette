package com.pierrette.api.configuration;

import com.pierrette.api.enumeration.Role;
import com.pierrette.api.services.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final CustomUserDetailService customUserDetailService;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers(antMatcher("/error")).permitAll();
                    auth.requestMatchers(antMatcher("/docs")).permitAll();
<<<<<<< HEAD

                    auth.requestMatchers(antMatcher("/api/v1/auth/operateur/list")).permitAll();
                    auth.requestMatchers(antMatcher("/api/v1/auth/operateur/create")).permitAll();
                    auth.requestMatchers(antMatcher("/api/v1/auth/operateur/add")).permitAll();

                    auth.requestMatchers(antMatcher("/api/v1/auth/**")).permitAll();


=======
//                    auth.requestMatchers(antMatcher("/api/operateurs/list")).permitAll();
//                    auth.requestMatchers(antMatcher("/api/v1/auth/operateur/*")).permitAll();
//                    auth.requestMatchers(antMatcher("/api/v1/auth/paiement/*")).permitAll();
//                    auth.requestMatchers(antMatcher("/api/v1/auth/contribuable/*")).permitAll();
>>>>>>> 659e319d254b95a64eda10169643fcdbafc44e26
                    auth.requestMatchers(antMatcher("/configuration/ui")).permitAll();
                    auth.requestMatchers(antMatcher("/v3/api-docs/**")).permitAll();
                    auth.requestMatchers(antMatcher("/swagger-ui/*")).permitAll();
                    auth.requestMatchers(antMatcher("/swagger-ui/index.html")).permitAll();
                    auth.requestMatchers(antMatcher("/api/v1/auth/*")).permitAll();
                    auth.requestMatchers(antMatcher("/api/v1/auth/sign-up")).permitAll();
                    auth.requestMatchers(antMatcher("/api/v1/auth/sign-in")).permitAll();
                    auth.requestMatchers("/user").hasRole(Role.Operateur_formel.name());
                    auth.requestMatchers("/user").hasRole(Role.Operateur_informel.name());
                    auth.requestMatchers("/admin").hasRole(Role.Administrateur.name());
                    auth.anyRequest().authenticated();
                }).sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.csrf(csrf-> csrf.disable()).build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }
//
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*")); // Ajuste selon tes besoins
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
