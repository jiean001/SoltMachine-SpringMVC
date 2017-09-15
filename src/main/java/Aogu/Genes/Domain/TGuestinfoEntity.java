package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_guestinfo", schema = "machinesys", catalog = "")
public class TGuestinfoEntity {
    private int guestid;
    private String guestnum;
    private Integer guestnumtype;
    private Double score;
    private String freefield;

    @Id
    @Column(name = "guestid")
    public int getGuestid() {
        return guestid;
    }

    public void setGuestid(int guestid) {
        this.guestid = guestid;
    }

    @Basic
    @Column(name = "guestnum")
    public String getGuestnum() {
        return guestnum;
    }

    public void setGuestnum(String guestnum) {
        this.guestnum = guestnum;
    }

    @Basic
    @Column(name = "guestnumtype")
    public Integer getGuestnumtype() {
        return guestnumtype;
    }

    public void setGuestnumtype(Integer guestnumtype) {
        this.guestnumtype = guestnumtype;
    }

    @Basic
    @Column(name = "score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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

        TGuestinfoEntity that = (TGuestinfoEntity) o;

        if (guestid != that.guestid) return false;
        if (guestnum != null ? !guestnum.equals(that.guestnum) : that.guestnum != null) return false;
        if (guestnumtype != null ? !guestnumtype.equals(that.guestnumtype) : that.guestnumtype != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guestid;
        result = 31 * result + (guestnum != null ? guestnum.hashCode() : 0);
        result = 31 * result + (guestnumtype != null ? guestnumtype.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
