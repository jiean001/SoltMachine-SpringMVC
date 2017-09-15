package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_activitymachine", schema = "machinesys", catalog = "")
public class TActivitymachineEntity {
    private int activitymachineid;
    private Integer machineid;
    private Integer activityid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "activitymachineid")
    public int getActivitymachineid() {
        return activitymachineid;
    }

    public void setActivitymachineid(int activitymachineid) {
        this.activitymachineid = activitymachineid;
    }

    @Basic
    @Column(name = "machineid")
    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    @Basic
    @Column(name = "activityid")
    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
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

        TActivitymachineEntity that = (TActivitymachineEntity) o;

        if (activitymachineid != that.activitymachineid) return false;
        if (machineid != null ? !machineid.equals(that.machineid) : that.machineid != null) return false;
        if (activityid != null ? !activityid.equals(that.activityid) : that.activityid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activitymachineid;
        result = 31 * result + (machineid != null ? machineid.hashCode() : 0);
        result = 31 * result + (activityid != null ? activityid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
