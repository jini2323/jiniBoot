package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemLoginLog is a Querydsl query type for MemLoginLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemLoginLog extends EntityPathBase<MemLoginLog> {

    private static final long serialVersionUID = 691019962L;

    public static final QMemLoginLog memLoginLog = new QMemLoginLog("memLoginLog");

    public final StringPath idn = createString("idn");

    public final NumberPath<Long> lognum = createNumber("lognum", Long.class);

    public final DateTimePath<java.util.Date> logtime = createDateTime("logtime", java.util.Date.class);

    public final StringPath reip = createString("reip");

    public final StringPath status = createString("status");

    public final StringPath uagent = createString("uagent");

    public QMemLoginLog(String variable) {
        super(MemLoginLog.class, forVariable(variable));
    }

    public QMemLoginLog(Path<? extends MemLoginLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemLoginLog(PathMetadata metadata) {
        super(MemLoginLog.class, metadata);
    }

}

