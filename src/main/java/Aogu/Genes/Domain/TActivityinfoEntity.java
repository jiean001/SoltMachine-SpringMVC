package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_activityinfo", schema = "machinesys", catalog = "")
public class TActivityinfoEntity {
    private int activityid;
    private String activityname;
    private String activitydiscount;
    private Timestamp activitystarttime;
    private Timestamp activityendtime;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "activityid")
    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    @Basic
    @Column(name = "activityname")
    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    @Basic
    @Column(name = "activitydiscount")
    public String getActivitydiscount() {
        return activitydiscount;
    }

    public void setActivitydiscount(String activitydiscount) {
        this.activitydiscount = activitydiscount;
    }

    @Basic
    @Column(name = "activitystarttime")
    public Timestamp getActivitystarttime() {
        return activitystarttime;
    }

    public void setActivitystarttime(Timestamp activitystarttime) {
        this.activitystarttime = activitystarttime;
    }

    @Basic
    @Column(name = "activityendtime")
    public Timestamp getActivityendtime() {
        return activityendtime;
    }

    public void setActivityendtime(Timestamp activityendtime) {
        this.activityendtime = activityendtime;
    }

    @Basic
    @Column(name = "valid")
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "operatetime")
    public Timestamp getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Timestamp operatetime) {
        this.operatetime = operatetime;
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

        TActivityinfoEntity that = (TActivityinfoEntity) o;

        if (activityid != that.activityid) return false;
        if (activityname != null ? !activityname.equals(that.activityname) : that.activityname != null) return false;
        if (activitydiscount != null ? !activitydiscount.equals(that.activitydiscount) : that.activitydiscount != null)
            return false;
        if (activitystarttime != null ? !activitystarttime.equals(that.activitystarttime) : that.activitystarttime != null)
            return false;
        if (activityendtime != null ? !activityendtime.equals(that.activityendtime) : that.activityendtime != null)
            return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityid;
        result = 31 * result + (activityname != null ? activityname.hashCode() : 0);
        result = 31 * result + (activitydiscount != null ? activitydiscount.hashCode() : 0);
        result = 31 * result + (activitystarttime != null ? activitystarttime.hashCode() : 0);
        result = 31 * result + (activityendtime != null ? activityendtime.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
