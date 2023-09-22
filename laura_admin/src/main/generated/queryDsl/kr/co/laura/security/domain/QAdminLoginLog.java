package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminLoginLog is a Querydsl query type for AdminLoginLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminLoginLog extends EntityPathBase<AdminLoginLog> {

    private static final long serialVersionUID = -1104289356L;

    public static final QAdminLoginLog adminLoginLog = new QAdminLoginLog("adminLoginLog");

    public final StringPath adid = createString("adid");

    public final NumberPath<Long> adlognum = createNumber("adlognum", Long.class);

    public final DateTimePath<java.util.Date> adlogtime = createDateTime("adlogtime", java.util.Date.class);

    public final StringPath adreip = createString("adreip");

    public final StringPath adstatus = createString("adstatus");

    public final StringPath aduagent = createString("aduagent");

    public QAdminLoginLog(String variable) {
        super(AdminLoginLog.class, forVariable(variable));
    }

    public QAdminLoginLog(Path<? extends AdminLoginLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminLoginLog(PathMetadata metadata) {
        super(AdminLoginLog.class, metadata);
    }

}

