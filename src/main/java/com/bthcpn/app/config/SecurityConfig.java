package com.bthcpn.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);
        http
                .authorizeRequests()
                    .antMatchers("/**/*.js").permitAll()
                    .antMatchers("/**/*.css").permitAll()
                    .antMatchers("/**/*.ttf").permitAll()
                    .antMatchers("/**/*.woff").permitAll()
                    .antMatchers("/**/*.woff2").permitAll()
                    .antMatchers("/**/*.eof").permitAll()
                    .antMatchers("/**/*.svg").permitAll()
                    .antMatchers("/**/*.ico").permitAll()
                    .antMatchers("/**/*.png").permitAll()
                    .antMatchers("/**/*.jpg").permitAll()
                    .antMatchers("/index", "/choiceAdminMenu", "/signup_vender").permitAll()
                    .antMatchers("/cheatPage").hasRole("MEMBER")
                    //.antMatchers("/cheatPage","/admin").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login_vender") //로그인페이지경로
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/index",true)
                    //.failureUrl("/login_vender?error=true")
                    .permitAll()
                .and()
                .logout()
                    .deleteCookies("SESSION")
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/index") //로그아웃 성공시
                    .invalidateHttpSession(true) //로그아웃시 세션 제거
                    .deleteCookies("JESSIONID") //쿠키제거
                .and()
                .sessionManagement()
                    .maximumSessions(1) /* session 허용 갯수 */
                    .expiredUrl("/login_vender") /* session 만료시 이동 페이지*/
                    .maxSessionsPreventsLogin(false); /* 동일한 사용자 로그인시 x, false 일 경우 기존 사용자 */
                //.permitAll();


    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
