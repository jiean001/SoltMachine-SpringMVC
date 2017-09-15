package Aogu.Genes.Domain;

import javax.persistence.*;

@Entity
@Table(name = "t_menu", schema = "machinesys", catalog = "")
public class TMenuEntity {
    private int menuid;
    private Integer parentmenuid;
    private String title;
    private String desp;
    private String url;
    private String freefield;

    @Id
    @Column(name = "menuid")
    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    @Basic
    @Column(name = "parentmenuid")
    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "desp")
    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

        TMenuEntity that = (TMenuEntity) o;

        if (menuid != that.menuid) return false;
        if (parentmenuid != null ? !parentmenuid.equals(that.parentmenuid) : that.parentmenuid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (desp != null ? !desp.equals(that.desp) : that.desp != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (freefield != null ? !freefield.equals(that.freefield) : that.freefield != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuid;
        result = 31 * result + (parentmenuid != null ? parentmenuid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (desp != null ? desp.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (freefield != null ? freefield.hashCode() : 0);
        return result;
    }
}
