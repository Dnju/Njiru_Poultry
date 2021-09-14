package njiru.poultry.com;

public class Chicken_ListsModel {
    private String Chicken;
    private String Vaccine;
    private String Date;

    private Chicken_ListsModel() {
    }

    private Chicken_ListsModel(String Chicken, String Vaccine, String Date) {
        this.Chicken = Chicken;
        this.Vaccine = Vaccine;
        this.Date=Date;
    }


    public String getChicken() {
        return Chicken;
    }

    public void setChicken(String chicken) {
        Chicken = chicken;
    }

    public String getVaccine() {
        return Vaccine;
    }

    public void setVaccine(String vaccine) {
        Vaccine = vaccine;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String vaccine) {
        Vaccine = Date;
    }
}
