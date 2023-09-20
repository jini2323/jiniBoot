
package kr.co.laura.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {

	//EntityManager 의 경우 @Autowired ㄴㄴㄴ 
	@PersistenceContext   //EntityManager 를 빈으로 주입할 때 사용하는 어노테이션
	private EntityManager entityManager;

	
	//JPAQueryFactory 를 Bean 으로 등록해서 프로젝트 전역에서 사용할 수 있도록 한다
	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}

}
