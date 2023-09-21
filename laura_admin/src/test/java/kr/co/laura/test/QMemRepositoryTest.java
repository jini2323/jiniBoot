package kr.co.laura.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import kr.co.laura.security.repository.QMemRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
@ActiveProfiles("local")
@Disabled
public class QMemRepositoryTest {
	
	@Autowired
	private QMemRepository qmemRepository;
	
	@Autowired
	EntityManager entityManager;
	
	

	  @Transactional
	  void testGetTodos() {

	    // Given
	    Mem mem = Mem.builder()
	    		.email("email")
	       // .title("Title Test")
	       // .description("Description Test")
	       // .completed(true)
	        .build();

	    // When
	    List<Mem> mems = qmemRepository.getMemList(null);

	    // Then
	    log.debug("mems:[{}]", mems);
	    assertTrue(!mems.isEmpty());
	  }

	  /**
	   * To-Do 목록을 설정
	   */
	  @Disabled
	  void setUpTodos() {

	    String title;
	    String description;
	    Boolean completed;

	    for (int a = 1; a <= 100; a++) {

	      title = "Title Test" + a;
	      description = "Description Test" + a;
	      if (a % 2 == 0) {
	        completed = true;
	      } else {
	        completed = false;
	      }
	      insertTodo(title, description, completed);
	    }

	    entityManager.flush();
	    entityManager.clear();
	  }

	  /**
	   * To-Do 한 건을 저장
	   */
	  @Disabled
	  void insertTodo(
	      String title,
	      String description,
	      Boolean completed) {
	    qmemRepository.save(
	        Mem.builder()
	        .email("email")
		       // .title("Title Test")
		       // .description("Description Test")
		       // .completed(true)
		        .build());
	  }
	
	
	
	

}
