// package br.cnj.primeiroprojeto;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {
//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         PasswordEncoder encoder = new BCryptPasswordEncoder();
//         encoder.encode("123");
        
//         auth.inMemoryAuthentication()
//         .withUser("allana").roles("User").password("{noop}123")
//         .and()
//         .withUser("admin").roles("Admin").password("{noop}123");
//     }

//     @Bean
//     SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http.authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("api/casos/**"))
//                     .hasRole("User"))
//                     .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("api/arquivos/**"))
//                     .hasRole("Admin")
//                     .anyRequest()
//                     .authenticated())
//                     .httpBasic(Customizer.withDefaults())
//                     .build();
//     }
// }
