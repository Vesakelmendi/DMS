package BL;

import BL.DeptPerms;
import BL.UserPerms;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(Rights.class)
public class Rights_ { 

    public static volatile CollectionAttribute<Rights, UserPerms> userPermsCollection;
    public static volatile SingularAttribute<Rights, Short> rightId;
    public static volatile SingularAttribute<Rights, String> description;
    public static volatile CollectionAttribute<Rights, DeptPerms> deptPermsCollection;

}