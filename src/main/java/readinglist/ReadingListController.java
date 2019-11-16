package readinglist;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
* @author halfdev
* @since 2019-11-09
* @ComponentScan 으로 ReadingListController 를 발견하여 자동으로 Spring Application Context에 Bean으로 등록하려고
* @Controller 를 붙인다.
*/
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;
    private Counter counter;
//    private MeterRegistry meterRegistry;
//    private Gauge gauge;


    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository
            , AmazonProperties amazonProperties
            , MeterRegistry meterRegistry) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
        counter = meterRegistry.counter("my.counter", "mytagname", "mytagvalue");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readerBooks(Model model, Reader reader) {
        List<Book> readingList = readingListRepository.findByReader(reader);

        if (readingList != null) {
            // key : books 로 Book 목록을 Model 에 추가하고, Model 을 readingList 로 반환
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }

        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Book book, Reader reader) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/"; // RedirectView ?
    }


}
