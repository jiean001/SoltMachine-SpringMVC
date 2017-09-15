package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_adinfo", schema = "machinesys", catalog = "")
public class TAdinfoEntity {
    private int adid;
    private String adname;
    private String adpath;
    private Timestamp adstarttime;
    private Timestamp adendtime;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "adid")
    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    @Basic
    @Column(name = "adname")
    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    @Basic
    @Column(name = "adpath")
    public String getAdpath() {
        return adpath;
    }

    public void setAdpath(String adpath) {
        this.adpath = adpath;
    }

    @Basic
    @Column(name = "adstarttime")
    public Timestamp getAdstarttime() {
        return adstarttime;
    }

    public void setAdstarttime(Timestamp adstarttime) {
        this.adstarttime = adstarttime;
    }

    @Basic
    @Column(name = "adendtime")
    public Timestamp getAdendtime() {
        return adendtime;
    }

    public void setAdendtime(Timestamp adendtime) {
        this.adendtime = adendtime;
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

        TAdinfoEntity that = (TAdinfoEntity) o;

        if (adid != that.adid) return false;
        if (adname != null ? !adname.equals(that.adname) : that.adname != null) return false;
        if (adpath != null ? !adpath.equals(that.adpath) : that.adpath != null) return false;
        if (adstarttime != null ? !adstarttime.equals(that.adstarttime) : that.adstarttime != null) return false;
        if (adendtime != null ? !adendtime.equals(that.adendtime) : that.adendtime != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adid;
        result = 31 * result + (adname != null ? adname.hashCode() : 0);
        result = 31 * result + (adpath != null ? adpath.hashCode() : 0);
        result = 31 * result + (adstarttime != null ? adstarttime.hashCode() : 0);
        result = 31 * result + (adendtime != null ? adendtime.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
