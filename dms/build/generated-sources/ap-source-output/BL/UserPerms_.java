package BL;

import BL.AccessLog;
import BL.Rights;
import BL.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(UserPerms.class)
public class UserPerms_ { 

    public static volatile SingularAttribute<UserPerms, AccessLog> fid;
    public static volatile SingularAttribute<UserPerms, User> uid;
    public static volatile SingularAttribute<UserPerms, Rights> rights;
    public static volatile SingularAttribute<UserPerms, Integer> userPermissionID;

}