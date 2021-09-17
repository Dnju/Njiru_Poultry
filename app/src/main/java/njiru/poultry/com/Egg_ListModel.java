package njiru.poultry.com;

public class Egg_ListModel {
    private String egg;

    //constructor
    private Egg_ListModel(){ }

    private Egg_ListModel(String egg){
        this.egg=egg;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }
}
