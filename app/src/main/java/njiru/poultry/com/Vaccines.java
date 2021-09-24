package njiru.poultry.com;

public class Vaccines {
    String Chicken, Description, Vaccine;

    public Vaccines(){

    }

    public Vaccines(String chicken, String description, String vaccine) {
        Chicken = chicken;
        Description = description;
        Vaccine = vaccine;
    }

    public String getChicken() {
        return Chicken;
    }

    public void setChicken(String chicken) {
        Chicken = chicken;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getVaccine() {
        return Vaccine;
    }

    public void setVaccine(String vaccine) {
        Vaccine = vaccine;
    }
}
