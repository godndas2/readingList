package readinglist;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author halfdev
* @since 2019-11-19
* /trace EndPoint 로 100개까지만 저장할 수 있다.
*/
@Configuration
public class ActuatorConfig {

    @Bean
    public InMemoryHttpTraceRepository traceRepository() {
        InMemoryHttpTraceRepository repository = new InMemoryHttpTraceRepository();
        repository.setCapacity(1000); // 용량을 10배 늘려 일부 Trace Entry 를 오래 보관한다.
        return repository;
    }
}
