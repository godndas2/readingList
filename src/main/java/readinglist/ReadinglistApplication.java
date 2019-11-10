package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
* @author halfdev
* @since 2019-11-09
*
*/
@SpringBootApplication
public class ReadinglistApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // login 경로를 login 템플릿으로 매핑
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // Reader 타입의 객체가 컨트롤러 매개변수로 있을 때 처리할 리졸버 설정
        resolvers.add(new ReaderHandlerMethodArgumentResolver());
    }
}
