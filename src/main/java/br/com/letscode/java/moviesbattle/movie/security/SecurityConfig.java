package br.com.letscode.java.moviesbattle.movie.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().disable()
            .csrf().disable()
            .authorizeRequests(authorize ->
                authorize
                    .antMatchers("/h2-console/**").permitAll()
                    .mvcMatchers("/movies/**", "/quiz/**").permitAll()
            )
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();

        //h2 console config
        http.headers().frameOptions().sameOrigin();
    }
}
