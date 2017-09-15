package Aogu.Genes.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_roles", schema = "machinesys", catalog = "")
public class TRolesEntity {
    private int roleid;
    private String rolename;
    private String roledesp;
    private String freefield;

    @Id
    @Column(name = "roleid")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="t_userroles",
            joinColumns={@JoinColumn(name="roleid",referencedColumnName = "roleid")},
            inverseJoinColumns={@JoinColumn(name="userid",referencedColumnName = "userid")})
    private Set<TUserinfoEntity> user = new HashSet<>();

    @Basic
    @Column(name = "rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Basic
    @Column(name = "roledesp")
    public String getRoledesp() {
        return roledesp;
    }

    public void setRoledesp(String roledesp) {
        this.roledesp = roledesp;
    }

    @Basic
    @Column(name = "freefield")
    public String getFreefield() {
        return freefield;
    }

    public void setFreefield(String freefield) {
        this.freefield = freefield;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRolesEntity that = (TRolesEntity) o;

        if (roleid != that.roleid) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;
        if (roledesp != null ? !roledesp.equals(that.roledesp) : that.roledesp != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        result = 31 * result + (roledesp != null ? roledesp.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
