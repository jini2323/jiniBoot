package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMem is a Querydsl query type for Mem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMem extends EntityPathBase<Mem> {

    private static final long serialVersionUID = 1277564031L;

    public static final QMem mem = new QMem("mem");

    public final StringPath addr = createString("addr");

    public final DateTimePath<java.util.Date> ardate = createDateTime("ardate", java.util.Date.class);

    public final StringPath arprofile = createString("arprofile");

    public final StringPath arstatus = createString("arstatus");

    public final StringPath bankaccount = createString("bankaccount");

    public final DateTimePath<java.util.Date> birthday = createDateTime("birthday", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath grade = createString("grade");

    public final DateTimePath<java.util.Date> mdate = createDateTime("mdate", java.util.Date.class);

    public final StringPath memgender = createString("memgender");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> num = createNumber("num", Long.class);

    public final StringPath profilepic = createString("profilepic");

    public final StringPath pwd = createString("pwd");

    public final EnumPath<RoleType> roleType = createEnum("roleType", RoleType.class);

    public final StringPath tel = createString("tel");

    public QMem(String variable) {
        super(Mem.class, forVariable(variable));
    }

    public QMem(Path<? extends Mem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMem(PathMetadata metadata) {
        super(Mem.class, metadata);
    }

}

