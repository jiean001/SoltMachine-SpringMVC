package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_rolepermission", schema = "machinesys", catalog = "")
public class TRolepermissionEntity {
    private int rolepermissionid;
    private Integer roleid;
    private Integer menuid;
    private Integer parentmenuid;
    private String freefield;

    @Id
    @Column(name = "rolepermissionid")
    public int getRolepermissionid() {
        return rolepermissionid;
    }

    public void setRolepermissionid(int rolepermissionid) {
        this.rolepermissionid = rolepermissionid;
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
    @Column(name = "menuid")
    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Basic
    @Column(name = "parentmenuid")
    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
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

        TRolepermissionEntity that = (TRolepermissionEntity) o;

        if (rolepermissionid != that.rolepermissionid) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        if (menuid != null ? !menuid.equals(that.menuid) : that.menuid != null) return false;
        if (parentmenuid != null ? !parentmenuid.equals(that.parentmenuid) : that.parentmenuid != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolepermissionid;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        result = 31 * result + (parentmenuid != null ? parentmenuid.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
