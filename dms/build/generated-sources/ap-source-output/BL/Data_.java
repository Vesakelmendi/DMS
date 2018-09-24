package BL;

import BL.AccessLog;
import BL.Category;
import BL.Departament;
import BL.DeptPerms;
import BL.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(Data.class)
public class Data_ { 

    public static volatile SingularAttribute<Data, User> owner;
    public static volatile SingularAttribute<Data, Date> created;
    public static volatile SingularAttribute<Data, String> description;
    public static volatile SingularAttribute<Data, User> reviewer;
    public static volatile CollectionAttribute<Data, DeptPerms> deptPermsCollection;
    public static volatile SingularAttribute<Data, Short> defaultRights;
    public static volatile SingularAttribute<Data, String> realname;
    public static volatile SingularAttribute<Data, String> path;
    public static volatile SingularAttribute<Data, Boolean> isDeleted;
    public static volatile SingularAttribute<Data, Integer> id;
    public static volatile SingularAttribute<Data, Category> category;
    public static volatile SingularAttribute<Data, Departament> department;
    public static volatile SingularAttribute<Data, Boolean> status;
    public static volatile CollectionAttribute<Data, AccessLog> accessLogCollection;

}