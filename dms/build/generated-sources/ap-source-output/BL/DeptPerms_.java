package BL;

import BL.Data;
import BL.Departament;
import BL.Rights;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T03:04:52")
@StaticMetamodel(DeptPerms.class)
public class DeptPerms_ { 

    public static volatile SingularAttribute<DeptPerms, Data> fid;
    public static volatile SingularAttribute<DeptPerms, String> deptPermissionID;
    public static volatile SingularAttribute<DeptPerms, Rights> rights;
    public static volatile SingularAttribute<DeptPerms, Departament> deptId;

}