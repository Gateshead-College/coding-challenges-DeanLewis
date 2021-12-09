package encapsulation.sunday_roast;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeRoast {

    SuperSecretSundayRoast roast = new SuperSecretSundayRoast();

    public static void main(String[] args) {
        MakeRoast mr = new MakeRoast();
        mr.menu();
    }

    private void menu(){
        System.out.println("Hi, welcome back, what do you want to do?");
        System.out.println("1 - Add an Ingredient");
        System.out.println("2 - Check Ingredients");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if(choice == 1){
            addIngredient();
        }
        else if(choice == 2){
            checkIngredients();
        }
        menu();
    }

    private void addIngredient() {
        System.out.println("What would you like to add?");
        String ingName = new Scanner(System.in).nextLine();
        System.out.println("How many would you like to add?");
        int ingCount = Integer.parseInt(new Scanner(System.in).nextLine());
        roast.addIngredient(new Ingredient(ingName, ingCount));
    }

    private void addIngredients(){
        roast.addIngredient(new Ingredient("Chicken", 12));
        roast.addIngredient(new Ingredient("Roast Potatoes", 200));
        roast.addIngredient(new Ingredient("Broccoli", 4));
        roast.addIngredient(new Ingredient("Cauliflower", 4));
        roast.addIngredient(new Ingredient("Peas", 7000));
        roast.addIngredient(new Ingredient("Carrots", 75));
        roast.addIngredient(new Ingredient("Cabbages", 4));
        roast.addIngredient(new Ingredient("Parsnips", 2));
        roast.addIngredient(new Ingredient("Brussel Sprouts", -1));

        roast.addIngredient((new Ingredient("Secret Ingredient", 1)));
    }

    private void checkIngredients(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("So, you want to view the ingredients eh? password first!");
        String password = myScanner.nextLine();
        ArrayList<Ingredient> ingredients = roast.getIngredients(password);
        if(ingredients != null) {
            for (Ingredient i : ingredients) {
                System.out.println("Ingredient: " + i.getIngredientName() +
                        ", Amount: " + i.getIngredientQuantity());
            }
        }
        else
            System.out.println("Caught you!");
    }
}

