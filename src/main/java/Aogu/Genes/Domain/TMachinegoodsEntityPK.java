package Aogu.Genes.Domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TMachinegoodsEntityPK implements Serializable {
    private int machineid;
    private int goodsid;

    @Column(name = "machineid")
    @Id
    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    @Column(name = "goodsid")
    @Id
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMachinegoodsEntityPK that = (TMachinegoodsEntityPK) o;

        if (machineid != that.machineid) return false;
        if (goodsid != that.goodsid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machineid;
        result = 31 * result + goodsid;
        return result;
    }
}
