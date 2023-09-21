package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = -613172875L;

    public static final QVisit visit = new QVisit("visit");

    public final NumberPath<Long> countNum = createNumber("countNum", Long.class);

    public final DatePath<java.util.Date> visitDate = createDate("visitDate", java.util.Date.class);

    public QVisit(String variable) {
        super(Visit.class, forVariable(variable));
    }

    public QVisit(Path<? extends Visit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVisit(PathMetadata metadata) {
        super(Visit.class, metadata);
    }

}

