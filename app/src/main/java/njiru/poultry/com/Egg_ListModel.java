package njiru.poultry.com;

public class Egg_ListModel {
    private String Eggs;

    //constructor
    private Egg_ListModel(){ }

    private Egg_ListModel(String Eggs){
        this.Eggs=Eggs;
    }

    public String getEggs() {
        return Eggs;
    }

    public void setEggs(String Eggs) {
        this.Eggs = Eggs;
    }
}
