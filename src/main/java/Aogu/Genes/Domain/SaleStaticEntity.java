package Aogu.Genes.Domain;

import javax.persistence.*;

/**
 * Created by wuxm on 2017/8/24.
 */

@Entity
@Table(name = "t_stalestaticinfo", schema = "machinesys", catalog = "")
public class SaleStaticEntity {
    @Basic
    @Column(name = "machineid")
    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    @Basic
    @Column(name = "month")
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Basic
    @Column(name = "salesnum")
    public int getSalesnum() {
        return salesnum;
    }

    public void setSalesnum(int salesnum) {
        this.salesnum = salesnum;
    }

    @Id
    @Column(name = "salestaticid")
    public int getSalestaticid() {
        return salestaticid;
    }

    public void setSalestaticid(int salestaticid) {
        this.salestaticid = salestaticid;
    }

    int salestaticid;
    int machineid;
    int month;
    int salesnum;
}
