package BL;

import BL.Data;
import BL.Log;
import BL.User;
import BL.UserPerms;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(AccessLog.class)
public class AccessLog_ { 

    public static volatile SingularAttribute<AccessLog, Integer> accessLogID;
    public static volatile CollectionAttribute<AccessLog, UserPerms> userPermsCollection;
    public static volatile SingularAttribute<AccessLog, String> action;
    public static volatile CollectionAttribute<AccessLog, Log> logCollection;
    public static volatile SingularAttribute<AccessLog, User> userId;
    public static volatile SingularAttribute<AccessLog, Date> timestamp;
    public static volatile SingularAttribute<AccessLog, Data> fileId;

}