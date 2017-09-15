package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_goodsinfo", schema = "machinesys", catalog = "")
public class TGoodsinfoEntity {
    private int goodsid;
    private TGoodskindinfoEntity goodskind;
    private String goodsname;
    private String goodsintroduction;
    private String goodspicpath;
    private Integer goodsscore;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "goodsid")
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @ManyToOne
    @JoinColumn(name = "goodskindid", referencedColumnName = "goodskindid")
    public TGoodskindinfoEntity getGoodskind() {
        return goodskind;
    }

    public void setGoodskind(TGoodskindinfoEntity goodskind) {
        this.goodskind = goodskind;
    }

    @Basic
    @Column(name = "goodsname")
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "goodsintroduction")
    public String getGoodsintroduction() {
        return goodsintroduction;
    }

    public void setGoodsintroduction(String goodsintroduction) {
        this.goodsintroduction = goodsintroduction;
    }

    @Basic
    @Column(name = "goodspicpath")
    public String getGoodspicpath() {
        return goodspicpath;
    }

    public void setGoodspicpath(String goodspicpath) {
        this.goodspicpath = goodspicpath;
    }

    @Basic
    @Column(name = "goodsscore")
    public Integer getGoodsscore() {
        return goodsscore;
    }

    public void setGoodsscore(Integer goodsscore) {
        this.goodsscore = goodsscore;
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

        TGoodsinfoEntity that = (TGoodsinfoEntity) o;

        if (goodsid != that.goodsid) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (goodsintroduction != null ? !goodsintroduction.equals(that.goodsintroduction) : that.goodsintroduction != null)
            return false;
        if (goodspicpath != null ? !goodspicpath.equals(that.goodspicpath) : that.goodspicpath != null) return false;
        if (goodsscore != null ? !goodsscore.equals(that.goodsscore) : that.goodsscore != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsid;
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsintroduction != null ? goodsintroduction.hashCode() : 0);
        result = 31 * result + (goodspicpath != null ? goodspicpath.hashCode() : 0);
        result = 31 * result + (goodsscore != null ? goodsscore.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
