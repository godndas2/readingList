package readinglist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncodeTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    * insert into oauth_client_details(client_id, resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove)
values('testClientId',null,'{bcrypt}$2a$10$H2oQgFY7qCRHWqkvAV4P6ONy2v74wfr3fQv.xERw3BJYSqh/Gcgrq','read,write','authorization_code,refresh_token','http://localhost:8081/oauth2/callback','ROLE_USER',36000,50000,null,null);
    * */
    @Test
    public void encodeTest() {
        System.out.printf("password : %s\n", passwordEncoder.encode("1234"));
    }
}
