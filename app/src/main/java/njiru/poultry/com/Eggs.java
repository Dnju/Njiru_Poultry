package njiru.poultry.com;

public class Eggs {
    String eggs;

    //Firebase constructor
    public  Eggs(){
    }

    //Eggs constructor
    public Eggs(String eggs) {
        this.eggs = eggs;
    }

    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }
}
