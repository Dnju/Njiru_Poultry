package njiru.poultry.com;

public class MealModel {
    private String meal;
    private String quantity;

    private MealModel(){}

    private MealModel(String meal,String quantity){
        this.meal=meal;
        this.quantity=quantity;

    }



    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
