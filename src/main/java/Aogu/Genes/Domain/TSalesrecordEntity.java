package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_salesrecord", schema = "machinesys", catalog = "")
public class TSalesrecordEntity {
    private int salesrecordid;
    private Integer machineid;
    private Integer goodsid;
    private Integer guestid;
    private Double saleprice;
    private Timestamp saletime;
    private String freefield;

    @Id
    @Column(name = "salesrecordid")
    public int getSalesrecordid() {
        return salesrecordid;
    }

    public void setSalesrecordid(int salesrecordid) {
        this.salesrecordid = salesrecordid;
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
    @Column(name = "goodsid")
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "guestid")
    public Integer getGuestid() {
        return guestid;
    }

    public void setGuestid(Integer guestid) {
        this.guestid = guestid;
    }

    @Basic
    @Column(name = "saleprice")
    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    @Basic
    @Column(name = "saletime")
    public Timestamp getSaletime() {
        return saletime;
    }

    public void setSaletime(Timestamp saletime) {
        this.saletime = saletime;
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

        TSalesrecordEntity that = (TSalesrecordEntity) o;

        if (salesrecordid != that.salesrecordid) return false;
        if (machineid != null ? !machineid.equals(that.machineid) : that.machineid != null) return false;
        if (goodsid != null ? !goodsid.equals(that.goodsid) : that.goodsid != null) return false;
        if (guestid != null ? !guestid.equals(that.guestid) : that.guestid != null) return false;
        if (saleprice != null ? !saleprice.equals(that.saleprice) : that.saleprice != null) return false;
        if (saletime != null ? !saletime.equals(that.saletime) : that.saletime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = salesrecordid;
        result = 31 * result + (machineid != null ? machineid.hashCode() : 0);
        result = 31 * result + (goodsid != null ? goodsid.hashCode() : 0);
        result = 31 * result + (guestid != null ? guestid.hashCode() : 0);
        result = 31 * result + (saleprice != null ? saleprice.hashCode() : 0);
        result = 31 * result + (saletime != null ? saletime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
