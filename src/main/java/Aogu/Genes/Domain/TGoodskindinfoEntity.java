package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_goodskindinfo", schema = "machinesys", catalog = "")
public class TGoodskindinfoEntity {
    private int goodskindid;
    private TGoodskindinfoEntity fathergoodskind;
    private String goodskind;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "goodskindid")
    public int getGoodskindid() {
        return goodskindid;
    }

    public void setGoodskindid(int goodskindid) {
        this.goodskindid = goodskindid;
    }

    @ManyToOne
    @JoinColumn(name = "fathergoodskindid", referencedColumnName = "goodskindid")
    public TGoodskindinfoEntity getFathergoodskind() {
        return fathergoodskind;
    }

    public void setFathergoodskind(TGoodskindinfoEntity fathergoodskind) {
        this.fathergoodskind = fathergoodskind;
    }

    @Basic
    @Column(name = "goodskind")
    public String getGoodskind() {
        return goodskind;
    }

    public void setGoodskind(String goodskind) {
        this.goodskind = goodskind;
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

        TGoodskindinfoEntity that = (TGoodskindinfoEntity) o;

        if (goodskindid != that.goodskindid) return false;
        if (goodskind != null ? !goodskind.equals(that.goodskind) : that.goodskind != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodskindid;
        result = 31 * result + (goodskind != null ? goodskind.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
