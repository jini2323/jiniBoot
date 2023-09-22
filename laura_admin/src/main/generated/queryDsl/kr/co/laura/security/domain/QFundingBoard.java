package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFundingBoard is a Querydsl query type for FundingBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFundingBoard extends EntityPathBase<FundingBoard> {

    private static final long serialVersionUID = -315227521L;

    public static final QFundingBoard fundingBoard = new QFundingBoard("fundingBoard");

    public final StringPath actpic = createString("actpic");

    public final StringPath content = createString("content");

    public final StringPath contentimg = createString("contentimg");

    public final NumberPath<Long> cost = createNumber("cost", Long.class);

    public final DateTimePath<java.util.Date> fdate = createDateTime("fdate", java.util.Date.class);

    public final StringPath funbudget = createString("funbudget");

    public final StringPath funcategory = createString("funcategory");

    public final NumberPath<Long> funnum = createNumber("funnum", Long.class);

    public final StringPath funpreview = createString("funpreview");

    public final StringPath funpurpose = createString("funpurpose");

    public final StringPath funtitle = createString("funtitle");

    public final StringPath funvideo = createString("funvideo");

    public final StringPath funwriter = createString("funwriter");

    public final DateTimePath<java.util.Date> fupdate = createDateTime("fupdate", java.util.Date.class);

    public final NumberPath<Long> fupmemnum = createNumber("fupmemnum", Long.class);

    public final StringPath postimgn = createString("postimgn");

    public final DateTimePath<java.util.Date> sdate = createDateTime("sdate", java.util.Date.class);

    public final NumberPath<Long> targetprice = createNumber("targetprice", Long.class);

    public QFundingBoard(String variable) {
        super(FundingBoard.class, forVariable(variable));
    }

    public QFundingBoard(Path<? extends FundingBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFundingBoard(PathMetadata metadata) {
        super(FundingBoard.class, metadata);
    }

}

