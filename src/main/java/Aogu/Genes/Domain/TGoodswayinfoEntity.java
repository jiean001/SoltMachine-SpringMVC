package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_goodswayinfo", schema = "machinesys", catalog = "")
public class TGoodswayinfoEntity {
    private int goodswayid;
    private TMachinetypeEntity machinetype;
    private Integer goodswaynum;
    private String goodswaysize;
    private String freefield;

    @Id
    @Column(name = "goodswayid")
    public int getGoodswayid() {
        return goodswayid;
    }

    public void setGoodswayid(int goodswayid) {
        this.goodswayid = goodswayid;
    }

    @ManyToOne
    @JoinColumn(name = "machinetypeid", referencedColumnName = "machinetypeid")
    public TMachinetypeEntity getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(TMachinetypeEntity machinetype) {
        this.machinetype = machinetype;
    }

    @Basic
    @Column(name = "goodswaynum")
    public Integer getGoodswaynum() {
        return goodswaynum;
    }

    public void setGoodswaynum(Integer goodswaynum) {
        this.goodswaynum = goodswaynum;
    }

    @Basic
    @Column(name = "goodswaysize")
    public String getGoodswaysize() {
        return goodswaysize;
    }

    public void setGoodswaysize(String goodswaysize) {
        this.goodswaysize = goodswaysize;
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

        TGoodswayinfoEntity that = (TGoodswayinfoEntity) o;

        if (goodswayid != that.goodswayid) return false;
        if (goodswaynum != null ? !goodswaynum.equals(that.goodswaynum) : that.goodswaynum != null) return false;
        if (goodswaysize != null ? !goodswaysize.equals(that.goodswaysize) : that.goodswaysize != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodswayid;
        result = 31 * result + (goodswaynum != null ? goodswaynum.hashCode() : 0);
        result = 31 * result + (goodswaysize != null ? goodswaysize.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
