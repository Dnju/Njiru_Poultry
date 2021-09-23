package njiru.poultry.com;

public class Vaccines {
    String CHIC, DESC, VAC;
//Empty constructor for Firestore
public Vaccines(){}


    public Vaccines(String CHIC, String DESC, String VAC) {
        this.CHIC = CHIC;
        this.DESC = DESC;
        this.VAC = VAC;
    }

    public String getCHIC() {
        return CHIC;
    }

    public void setCHIC(String CHIC) {
        this.CHIC = CHIC;
    }

    public String getDESC() {
        return DESC;
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public String getVAC() {
        return VAC;
    }

    public void setVAC(String VAC) {
        this.VAC = VAC;
    }
}
