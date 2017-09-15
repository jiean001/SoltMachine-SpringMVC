package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_goodswaygoods", schema = "machinesys", catalog = "")
public class TGoodswaygoodsEntity {
    private int goodswaygoodsid;
    private TGoodsinfoEntity goods;
    private TMachinegoodsEntity machinegoodsentity;
    private Integer machineid;
    private Integer goodswaynum;
    private Integer goodsnum;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "goodswaygoodsid")
    public int getGoodswaygoodsid() {
        return goodswaygoodsid;
    }

    public void setGoodswaygoodsid(int goodswaygoodsid) {
        this.goodswaygoodsid = goodswaygoodsid;
    }

    @ManyToOne
    @JoinColumn(name = "goodsid", referencedColumnName = "goodsid")
    public TGoodsinfoEntity getGoods() {
        return goods;
    }

    public void setGoods(TGoodsinfoEntity goods) {
        this.goods = goods;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "machineid", referencedColumnName = "machineid", insertable = false, updatable = false),
            @JoinColumn(name = "goodsid", referencedColumnName = "goodsid", insertable = false, updatable = false)
    })

    public TMachinegoodsEntity getMachinegoodsentity() {
        return machinegoodsentity;
    }

    public void setMachinegoodsentity(TMachinegoodsEntity machinegoodsentity) {
        this.machinegoodsentity = machinegoodsentity;
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
    @Column(name = "goodswaynum")
    public Integer getGoodswaynum() {
        return goodswaynum;
    }

    public void setGoodswaynum(Integer goodswaynum) {
        this.goodswaynum = goodswaynum;
    }

    @Basic
    @Column(name = "goodsnum")
    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
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

        TGoodswaygoodsEntity that = (TGoodswaygoodsEntity) o;

        if (goodswaygoodsid != that.goodswaygoodsid) return false;
        if (machineid != null ? !machineid.equals(that.machineid) : that.machineid != null) return false;
        if (goodswaynum != null ? !goodswaynum.equals(that.goodswaynum) : that.goodswaynum != null) return false;
        if (goodsnum != null ? !goodsnum.equals(that.goodsnum) : that.goodsnum != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodswaygoodsid;
        result = 31 * result + (machineid != null ? machineid.hashCode() : 0);
        result = 31 * result + (goodswaynum != null ? goodswaynum.hashCode() : 0);
        result = 31 * result + (goodsnum != null ? goodsnum.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
