package BL;

import BL.Data;
import BL.DeptPerms;
import BL.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(Departament.class)
public class Departament_ { 

    public static volatile CollectionAttribute<Departament, User> userCollection;
    public static volatile SingularAttribute<Departament, String> name;
    public static volatile SingularAttribute<Departament, Integer> id;
    public static volatile CollectionAttribute<Departament, DeptPerms> deptPermsCollection;
    public static volatile CollectionAttribute<Departament, Data> dataCollection;

}