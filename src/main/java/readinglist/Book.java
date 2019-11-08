package readinglist;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* @author halfdev
* @since 2019-11-09
* Property 와 Accessor Method 가 있는 간단한 Java Object
*/
@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reader;

    private String isbn;

    private String title;

    private String author;

    private String description;
}
