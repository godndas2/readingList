package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
* @author halfdev
* @since 2019-11-09
* JpaRepository 는 Interface Type Parameter 를 두 개 받는다.
* <도메인 타입, 클래스 ID의 프로퍼티 타입>
*/
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    // 지정한 독자 이름으로 독서목록 검색
    List<Book> findByReader(String reader);
}
