package njiru.poultry.com;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EggtestModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vaccId")
    @Expose
    private Integer vaccId;
    @SerializedName("duedate")
    @Expose
    private String duedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVaccId() {
        return vaccId;
    }

    public void setVaccId(Integer vaccId) {
        this.vaccId = vaccId;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}
