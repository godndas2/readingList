package readinglist;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final ReaderRepository readerRepository;
    private final LoginAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()

                .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')") // READER 권한 필요
                .antMatchers("/**").permitAll()

                .and()

                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }

    /**
    * @author halfdev
    * @since 2019-11-10
    * UserDetailsService 를 구현하고, 제공된 username 으로 사용자의 상세 정보를 조회함
    */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserDetailsService() {
//
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                // return readerRepository.findOne(username);
//                return readerRepository.findById(username).get();
//            }
//        });
//    }

//     test 용도
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("halfdev")
                .password("{noop}1234")
                .roles("READER");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider);
//    }

}
