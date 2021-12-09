package encapsulation.sunday_roast;

public class Ingredient {

    private final String ingredientName;
    private final int ingredientQuantity;

    public Ingredient(String ingredientName, int ingredientQuantity) {
        this.ingredientName = ingredientName;
        this.ingredientQuantity = ingredientQuantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }
}

