package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_machinegoods", schema = "machinesys", catalog = "")
@IdClass(TMachinegoodsEntityPK.class)
public class TMachinegoodsEntity {
    private int machineid;
    private int goodsid;
    private Double price;
    private String freefield;

    @Id
    @Column(name = "machineid")
    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    @Id
    @Column(name = "goodsid")
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

        TMachinegoodsEntity that = (TMachinegoodsEntity) o;

        if (machineid != that.machineid) return false;
        if (goodsid != that.goodsid) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machineid;
        result = 31 * result + goodsid;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
