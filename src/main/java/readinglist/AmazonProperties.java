package readinglist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* @author halfdev
* @since 2019-11-14
* Amazon 에 주요 구성 Property
*/
@Component
@ConfigurationProperties("amazon")
@Getter
@Setter
public class AmazonProperties {

    private String associateId;

}
