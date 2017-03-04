package com.codecool.hccrm.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.codecool.hccrm.model.RoleEnum.ROLE_ADMIN;
import static com.codecool.hccrm.model.RoleEnum.ROLE_CEO;

/**
 * Created by balag3 on 2017.02.09..
 */
@Configuration
public class AdminConfiguration extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AdminConfiguration.class);

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /* Override the configure method and permit all user to see the login and registration page
    and to log out. */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/regitrationConfirm", "/signup").permitAll()
                .antMatchers("/user/**").hasAnyRole("MANAGER", "ADMIN", "CEO")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler())
                //.failureHandler(authenticationFailureHandler())
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    /* Set the global passwordencoder to bycryptpwencoder. */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {

        return new SimpleUrlAuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request,
                                                HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {

                String targetUrl = determineTargetUrl(authentication);

                if (response.isCommitted()) {
                    logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
                    return;
                }

                getRedirectStrategy().sendRedirect(request, response, targetUrl);
            }

            private String determineTargetUrl(Authentication authentication) {
                Set<String> authorities1 = authentication.getAuthorities()
                                                    .stream()
                                                    .map(GrantedAuthority::getAuthority)
                                                    .collect(Collectors.toSet());
                if (authorities1.contains(ROLE_ADMIN.getRole())) return "/admin";
                if (authorities1.contains(ROLE_CEO.getRole())) return "/user/dashboard";
                else {
                    throw new IllegalStateException();
                }
            }
        };
    }

    /**
     * Creates a custom AuthenticationFailureHandler
     * It returns custom errors with {@link HttpServletResponse#SC_UNAUTHORIZED} (401) HTTP Status.
     *
     * @return AuthenticationFailureHandler
     */
//    @Bean
//    AuthenticationFailureHandler authenticationFailureHandler() {
//        return (request, response, exception) -> {
//                //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User account suspended");
//                response.sendRedirect("/login?error=Failed");
//
//        };
//    }

}
