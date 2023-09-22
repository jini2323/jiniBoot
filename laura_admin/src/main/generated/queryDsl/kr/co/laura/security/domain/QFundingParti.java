package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFundingParti is a Querydsl query type for FundingParti
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFundingParti extends EntityPathBase<FundingParti> {

    private static final long serialVersionUID = -302698897L;

    public static final QFundingParti fundingParti = new QFundingParti("fundingParti");

    public final NumberPath<Long> fmem_num = createNumber("fmem_num", Long.class);

    public final NumberPath<Long> funmoney = createNumber("funmoney", Long.class);

    public final NumberPath<Long> funnum_num = createNumber("funnum_num", Long.class);

    public final StringPath funstatus = createString("funstatus");

    public final DateTimePath<java.util.Date> joindate = createDateTime("joindate", java.util.Date.class);

    public QFundingParti(String variable) {
        super(FundingParti.class, forVariable(variable));
    }

    public QFundingParti(Path<? extends FundingParti> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFundingParti(PathMetadata metadata) {
        super(FundingParti.class, metadata);
    }

}

