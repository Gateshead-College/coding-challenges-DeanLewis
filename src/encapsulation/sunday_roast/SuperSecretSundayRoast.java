package encapsulation.sunday_roast;

import java.util.ArrayList;

class SuperSecretSundayRoast {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    ArrayList<String> guestList = new ArrayList<>();


    public SuperSecretSundayRoast() {
        populateGuestList();
    }

    private void populateGuestList(){
        guestList.add("Chicken");
        guestList.add("Roast Potatoes");
        guestList.add("Broccoli");
        guestList.add("Cauliflower");
        guestList.add("Peas");
        guestList.add("Carrots");
        guestList.add("Cabbages");
        guestList.add("Parsnips");
        guestList.add("Brussel Sprouts");
        guestList.add("Secret Ingredient");
    }

    public void addIngredient(Ingredient i){
        if(guestList.contains(i.getIngredientName())) {
            this.ingredients.add(i);
            System.out.println(i.getIngredientName() + " has been added");
        }
        else {
            System.out.println("EXTERMINATE!, unauthorised ingredient!");
        }
    }

    public ArrayList<Ingredient> getIngredients(String password){
        if(password.equals("strongpassword123")) {
            return this.ingredients;
        }
        else
            return null;
    }
}

