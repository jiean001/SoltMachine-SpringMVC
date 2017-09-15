package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_userroles", schema = "machinesys", catalog = "")
public class TUserrolesEntity {
    private int userrolesid;
    private Integer roleid;
    private Integer userid;
    private String freefield;

    @Id
    @Column(name = "userrolesid")
    public int getUserrolesid() {
        return userrolesid;
    }

    public void setUserrolesid(int userrolesid) {
        this.userrolesid = userrolesid;
    }

    @Basic
    @Column(name = "roleid")
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

        TUserrolesEntity that = (TUserrolesEntity) o;

        if (userrolesid != that.userrolesid) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userrolesid;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
