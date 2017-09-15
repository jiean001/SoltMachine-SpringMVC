package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_businessinfo", schema = "machinesys", catalog = "")
public class TBusinessinfoEntity {
    private int businessid;
    private String businessname;
    private String contacts;
    private String creditcode;
    private String address;
    private String phone;
    private String area;
    private Integer fatherbusinessid;
    private String alipay;
    private String wechatPay;
    private Integer valid;
    private String operator;
    private Timestamp operatetime;
    private String freefiled;
    private Integer userid;

    @Id
    @Column(name = "businessid")
    public int getBusinessid() {
        return businessid;
    }

    public void setBusinessid(int businessid) {
        this.businessid = businessid;
    }

    @Basic
    @Column(name = "businessname")
    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "creditcode")
    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "fatherbusinessid")
    public Integer getFatherbusinessid() {
        return fatherbusinessid;
    }

    public void setFatherbusinessid(Integer fatherbusinessid) {
        this.fatherbusinessid = fatherbusinessid;
    }

    @Basic
    @Column(name = "alipay")
    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    @Basic
    @Column(name = "wechatPay")
    public String getWechatPay() {
        return wechatPay;
    }

    public void setWechatPay(String wechatPay) {
        this.wechatPay = wechatPay;
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
    @Column(name = "freefiled")
    public String getFreefiled() {
        return freefiled;
    }

    public void setFreefiled(String freefiled) {
        this.freefiled = freefiled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TBusinessinfoEntity that = (TBusinessinfoEntity) o;

        if (businessid != that.businessid) return false;
        if (businessname != null ? !businessname.equals(that.businessname) : that.businessname != null) return false;
        if (contacts != null ? !contacts.equals(that.contacts) : that.contacts != null) return false;
        if (creditcode != null ? !creditcode.equals(that.creditcode) : that.creditcode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (fatherbusinessid != null ? !fatherbusinessid.equals(that.fatherbusinessid) : that.fatherbusinessid != null)
            return false;
        if (alipay != null ? !alipay.equals(that.alipay) : that.alipay != null) return false;
        if (wechatPay != null ? !wechatPay.equals(that.wechatPay) : that.wechatPay != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefiled != null ? !freefiled.equals(that.freefiled) : that.freefiled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = businessid;
        result = 31 * result + (businessname != null ? businessname.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (creditcode != null ? creditcode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (fatherbusinessid != null ? fatherbusinessid.hashCode() : 0);
        result = 31 * result + (alipay != null ? alipay.hashCode() : 0);
        result = 31 * result + (wechatPay != null ? wechatPay.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefiled != null ? freefiled.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
