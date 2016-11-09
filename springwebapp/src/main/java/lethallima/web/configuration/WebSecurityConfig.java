package lethallima.web.configuration;

import lethallima.web.helpers.Const;
import lethallima.web.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by LethalLima on 7/2/16.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/resources/**").permitAll()
                .antMatchers("/login", "/login/create").permitAll()
                .antMatchers(HttpMethod.GET, "/users/{id:^[\\d]+$}").authenticated()
                .antMatchers(HttpMethod.GET, "/users/{id:^[a-zA-Z]+$}").authenticated()
                .antMatchers("/users/**").hasAuthority(Const.ROLE_ADMIN)
                .antMatchers("/admin/**").hasAuthority(Const.ROLE_ADMIN)
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .successHandler(authSuccessHandler)
//                    .defaultSuccessUrl("/dashboard")
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout");
    }

    @Bean(name="authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
