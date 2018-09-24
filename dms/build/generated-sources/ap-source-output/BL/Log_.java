package BL;

import BL.AccessLog;
import BL.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, String> note;
    public static volatile SingularAttribute<Log, Date> modifiedOn;
    public static volatile SingularAttribute<Log, String> logID;
    public static volatile SingularAttribute<Log, User> modifiedBy;
    public static volatile SingularAttribute<Log, AccessLog> id;
    public static volatile SingularAttribute<Log, String> revision;

}