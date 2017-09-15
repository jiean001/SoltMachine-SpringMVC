package Aogu.Genes.Domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "t_machine", schema = "machinesys", catalog = "")
public class TMachineEntity {
    private int machineid;
    private Integer businessid;
    private TMachinetypeEntity machinetype;
    private Integer mask;
    private String machinenum;
    private String machineip;
    private String portnum;
    private String macaddress;
    private String machineplace;
    private String manufacturer;
    private Date producetime;
    private Integer machinestate;
    private String operator;
    private Timestamp operatetime;
    private String freefield;

    @Id
    @Column(name = "machineid")
    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    @Basic
    @Column(name = "businessid")
    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    @ManyToOne
    @JoinColumn(name = "machinetypeid", referencedColumnName = "machinetypeid")
    public TMachinetypeEntity getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(TMachinetypeEntity machinetype) {
        this.machinetype = machinetype;
    }

    @Basic
    @Column(name = "mask")
    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Basic
    @Column(name = "machinenum")
    public String getMachinenum() {
        return machinenum;
    }

    public void setMachinenum(String machinenum) {
        this.machinenum = machinenum;
    }

    @Basic
    @Column(name = "machineip")
    public String getMachineip() {
        return machineip;
    }

    public void setMachineip(String machineip) {
        this.machineip = machineip;
    }

    @Basic
    @Column(name = "portnum")
    public String getPortnum() {
        return portnum;
    }

    public void setPortnum(String portnum) {
        this.portnum = portnum;
    }

    @Basic
    @Column(name = "macaddress")
    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    @Basic
    @Column(name = "machineplace")
    public String getMachineplace() {
        return machineplace;
    }

    public void setMachineplace(String machineplace) {
        this.machineplace = machineplace;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "producetime")
    public Date getProducetime() {
        return producetime;
    }

    public void setProducetime(Date producetime) {
        this.producetime = producetime;
    }

    @Basic
    @Column(name = "machinestate")
    public Integer getMachinestate() {
        return machinestate;
    }

    public void setMachinestate(Integer machinestate) {
        this.machinestate = machinestate;
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

        TMachineEntity that = (TMachineEntity) o;

        if (machineid != that.machineid) return false;
        if (businessid != null ? !businessid.equals(that.businessid) : that.businessid != null) return false;
        if (mask != null ? !mask.equals(that.mask) : that.mask != null) return false;
        if (machinenum != null ? !machinenum.equals(that.machinenum) : that.machinenum != null) return false;
        if (machineip != null ? !machineip.equals(that.machineip) : that.machineip != null) return false;
        if (portnum != null ? !portnum.equals(that.portnum) : that.portnum != null) return false;
        if (macaddress != null ? !macaddress.equals(that.macaddress) : that.macaddress != null) return false;
        if (machineplace != null ? !machineplace.equals(that.machineplace) : that.machineplace != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (producetime != null ? !producetime.equals(that.producetime) : that.producetime != null) return false;
        if (machinestate != null ? !machinestate.equals(that.machinestate) : that.machinestate != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatetime != null ? !operatetime.equals(that.operatetime) : that.operatetime != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machineid;
        result = 31 * result + (businessid != null ? businessid.hashCode() : 0);
        result = 31 * result + (mask != null ? mask.hashCode() : 0);
        result = 31 * result + (machinenum != null ? machinenum.hashCode() : 0);
        result = 31 * result + (machineip != null ? machineip.hashCode() : 0);
        result = 31 * result + (portnum != null ? portnum.hashCode() : 0);
        result = 31 * result + (macaddress != null ? macaddress.hashCode() : 0);
        result = 31 * result + (machineplace != null ? machineplace.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (producetime != null ? producetime.hashCode() : 0);
        result = 31 * result + (machinestate != null ? machinestate.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatetime != null ? operatetime.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
