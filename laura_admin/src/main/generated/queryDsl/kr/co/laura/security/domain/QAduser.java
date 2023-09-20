package kr.co.laura.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAduser is a Querydsl query type for Aduser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAduser extends EntityPathBase<Aduser> {

    private static final long serialVersionUID = 1860716420L;

    public static final QAduser aduser = new QAduser("aduser");

    public final StringPath adEmail = createString("adEmail");

    public final NumberPath<Long> adNum = createNumber("adNum", Long.class);

    public final StringPath adPwd = createString("adPwd");

    public final StringPath adTel = createString("adTel");

    public final NumberPath<Integer> deptNo = createNumber("deptNo", Integer.class);

    public final EnumPath<RoleType> roleType = createEnum("roleType", RoleType.class);

    public QAduser(String variable) {
        super(Aduser.class, forVariable(variable));
    }

    public QAduser(Path<? extends Aduser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAduser(PathMetadata metadata) {
        super(Aduser.class, metadata);
    }

}

