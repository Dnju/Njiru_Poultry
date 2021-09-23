package njiru.poultry.com;

public class Chicken {
    private String Chicken, Vaccine, Date;


    public Chicken(){

    }

    public Chicken(String chicken, String vaccine, String date) {
        Chicken = chicken;
        Vaccine = vaccine;
        Date = date;
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

    public void setDate(String date) {
        Date = date;
    }
}
