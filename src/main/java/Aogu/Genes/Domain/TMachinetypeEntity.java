package Aogu.Genes.Domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "t_machinetype", schema = "machinesys", catalog = "")
public class TMachinetypeEntity {
    private int machinetypeid;
    private String machinetype;
    private Integer temperaturecontrol;
    private Integer adshow;
    private String freefield;
    private List<TGoodswayinfoEntity> goodswayinfo;

    @OneToMany(mappedBy = "machinetype")
    public List<TGoodswayinfoEntity> getGoodswayinfo() {
        return goodswayinfo;
    }

    public void setGoodswayinfo(List<TGoodswayinfoEntity> goodswayinfo) {
        this.goodswayinfo = goodswayinfo;
    }

    @Id
    @Column(name = "machinetypeid")
    public int getMachinetypeid() {
        return machinetypeid;
    }

    public void setMachinetypeid(int machinetypeid) {
        this.machinetypeid = machinetypeid;
    }

    @Basic
    @Column(name = "machinetype")
    public String getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(String machinetype) {
        this.machinetype = machinetype;
    }

    @Basic
    @Column(name = "temperaturecontrol")
    public Integer getTemperaturecontrol() {
        return temperaturecontrol;
    }

    public void setTemperaturecontrol(Integer temperaturecontrol) {
        this.temperaturecontrol = temperaturecontrol;
    }

    @Basic
    @Column(name = "adshow")
    public Integer getAdshow() {
        return adshow;
    }

    public void setAdshow(Integer adshow) {
        this.adshow = adshow;
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

        TMachinetypeEntity that = (TMachinetypeEntity) o;

        if (machinetypeid != that.machinetypeid) return false;
        if (machinetype != null ? !machinetype.equals(that.machinetype) : that.machinetype != null) return false;
        if (temperaturecontrol != null ? !temperaturecontrol.equals(that.temperaturecontrol) : that.temperaturecontrol != null)
            return false;
        if (adshow != null ? !adshow.equals(that.adshow) : that.adshow != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machinetypeid;
        result = 31 * result + (machinetype != null ? machinetype.hashCode() : 0);
        result = 31 * result + (temperaturecontrol != null ? temperaturecontrol.hashCode() : 0);
        result = 31 * result + (adshow != null ? adshow.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
