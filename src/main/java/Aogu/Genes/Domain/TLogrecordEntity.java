package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_logrecord", schema = "machinesys", catalog = "")
public class TLogrecordEntity {
    private int logrecordid;
    private Integer userid;
    private Timestamp logintime;
    private String loginip;

    @Id
    @Column(name = "logrecordid")
    public int getLogrecordid() {
        return logrecordid;
    }

    public void setLogrecordid(int logrecordid) {
        this.logrecordid = logrecordid;
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
    @Column(name = "logintime")
    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "loginip")
    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TLogrecordEntity that = (TLogrecordEntity) o;

        if (logrecordid != that.logrecordid) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (logintime != null ? !logintime.equals(that.logintime) : that.logintime != null) return false;
        if (loginip != null ? !loginip.equals(that.loginip) : that.loginip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logrecordid;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (logintime != null ? logintime.hashCode() : 0);
        result = 31 * result + (loginip != null ? loginip.hashCode() : 0);
        return result;
    }
}
