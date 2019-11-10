package readinglist;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
* @author halfdev
* @since 2019-11-10
* Login 정보 유효성 검증
*/
@RequiredArgsConstructor
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final ReaderRepository readerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Reader reader = readerRepository.findById(name).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));

        if (!passwordEncoder.matches(password, reader.getPassword()))
            throw new BadCredentialsException("password is not valid");

        return new UsernamePasswordAuthenticationToken(name, password, reader.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
