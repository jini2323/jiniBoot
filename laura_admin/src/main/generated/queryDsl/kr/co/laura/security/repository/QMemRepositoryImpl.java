package kr.co.laura.security.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.laura.security.domain.Mem;
import kr.co.laura.security.domain.QMem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QMemRepositoryImpl implements QMemRepositoryCustom {
	
	
	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<Mem> getMemList(Mem mem) {
		
		QMem qmem = QMem.mem;
		return jpaQueryFactory
				.selectFrom(qmem)
				.fetch();
	}
	
	
	
	
	

}
