package njiru.poultry.com;

public class Chicken_ListsModel {
    private String Chicken;
    private String Vaccine;

    private Chicken_ListsModel(){}

    private Chicken_ListsModel(String Chicken, String Vaccine){
        this.Chicken=Chicken;
        this.Vaccine=Vaccine;
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
}
