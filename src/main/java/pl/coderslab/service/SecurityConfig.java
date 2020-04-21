package pl.coderslab.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.service.SpringDataUserDetailsService;
import pl.coderslab.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/item/**").authenticated()
                .antMatchers("/category/**").authenticated()
                .antMatchers("/logout").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .permitAll();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

//    @Bean
//    public UserService customUserService(){
//        return new UserService()
//    }

}
