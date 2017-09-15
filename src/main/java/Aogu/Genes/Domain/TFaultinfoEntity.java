package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_faultinfo", schema = "machinesys", catalog = "")
public class TFaultinfoEntity {
    private int faultid;
    private TMachineEntity machine;
    private Integer faultcode;
    private Timestamp faulttime;
    private Timestamp solvetime;
    private String repairman;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "faultid")
    public int getFaultid() {
        return faultid;
    }

    public void setFaultid(int faultid) {
        this.faultid = faultid;
    }


    @ManyToOne
    @JoinColumn(name = "machineid", referencedColumnName = "machineid")
    public TMachineEntity getMachine() {
        return machine;
    }

    public void setMachine(TMachineEntity machine) {
        this.machine = machine;
    }

    @Basic
    @Column(name = "faultcode")
    public Integer getFaultcode() {
        return faultcode;
    }

    public void setFaultcode(Integer faultcode) {
        this.faultcode = faultcode;
    }

    @Basic
    @Column(name = "faulttime")
    public Timestamp getFaulttime() {
        return faulttime;
    }

    public void setFaulttime(Timestamp faulttime) {
        this.faulttime = faulttime;
    }

    @Basic
    @Column(name = "solvetime")
    public Timestamp getSolvetime() {
        return solvetime;
    }

    public void setSolvetime(Timestamp solvetime) {
        this.solvetime = solvetime;
    }

    @Basic
    @Column(name = "repairman")
    public String getRepairman() {
        return repairman;
    }

    public void setRepairman(String repairman) {
        this.repairman = repairman;
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

        TFaultinfoEntity that = (TFaultinfoEntity) o;

        if (faultid != that.faultid) return false;
        if (faultcode != null ? !faultcode.equals(that.faultcode) : that.faultcode != null) return false;
        if (faulttime != null ? !faulttime.equals(that.faulttime) : that.faulttime != null) return false;
        if (solvetime != null ? !solvetime.equals(that.solvetime) : that.solvetime != null) return false;
        if (repairman != null ? !repairman.equals(that.repairman) : that.repairman != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = faultid;
        result = 31 * result + (faultcode != null ? faultcode.hashCode() : 0);
        result = 31 * result + (faulttime != null ? faulttime.hashCode() : 0);
        result = 31 * result + (solvetime != null ? solvetime.hashCode() : 0);
        result = 31 * result + (repairman != null ? repairman.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
