package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "t_businessmaninfo", schema = "machinesys", catalog = "")
public class TBusinessmaninfoEntity {
    private int businessmanid;
    private Integer businessid;
    private TUserinfoEntity user;
    private String realname;
    private String idcard;
    private String phone;
    private Integer jobstate;
    private Date jobtime;
    private Date leavetime;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "businessmanid")
    public int getBusinessmanid() {
        return businessmanid;
    }

    public void setBusinessmanid(int businessmanid) {
        this.businessmanid = businessmanid;
    }

    @Basic
    @Column(name = "businessid")
    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    public TUserinfoEntity getUser() {
        return user;
    }

    public void setUser(TUserinfoEntity user) {
        this.user = user;
    }

    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "idcard")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "jobstate")
    public Integer getJobstate() {
        return jobstate;
    }

    public void setJobstate(Integer jobstate) {
        this.jobstate = jobstate;
    }

    @Basic
    @Column(name = "jobtime")
    public Date getJobtime() {
        return jobtime;
    }

    public void setJobtime(Date jobtime) {
        this.jobtime = jobtime;
    }

    @Basic
    @Column(name = "leavetime")
    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
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

        TBusinessmaninfoEntity that = (TBusinessmaninfoEntity) o;

        if (businessmanid != that.businessmanid) return false;
        if (businessid != null ? !businessid.equals(that.businessid) : that.businessid != null) return false;
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (jobstate != null ? !jobstate.equals(that.jobstate) : that.jobstate != null) return false;
        if (jobtime != null ? !jobtime.equals(that.jobtime) : that.jobtime != null) return false;
        if (leavetime != null ? !leavetime.equals(that.leavetime) : that.leavetime != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = businessmanid;
        result = 31 * result + (businessid != null ? businessid.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (jobstate != null ? jobstate.hashCode() : 0);
        result = 31 * result + (jobtime != null ? jobtime.hashCode() : 0);
        result = 31 * result + (leavetime != null ? leavetime.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
