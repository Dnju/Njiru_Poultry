package njiru.poultry.com;

public class Eggs {
    String Eggs;

    //Firebase constructor
    public  Eggs(){
    }

    //Eggs constructor
    public Eggs(String eggs) {
        this.Eggs = eggs;
    }

    public String getEggs() {
        return Eggs;
    }

    public void setEggs(String eggs) {
        this.Eggs = eggs;
    }
}
