package calculator;

import java.util.Scanner;

public class Calculator {

    /*
    Constant variables used to change the colour of console text.
    REMEMBER to use ANSI_RESET at the end of every line.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //Scanner instance to be used across the application.
    Scanner scn = new Scanner(System.in);
    //double variables to hold the first and second numbers.
    double firstNumber;
    double secondNumber;

    //String variable to hold the operator e.g. + - / * .
    String operand;

    //double variable to store the result of the calculation.
    double result;

    //double variable to act as memory store.
    double memory;

    //Main method - starting point for the program.
    public static void main(String[] args) {
        //create a new instance of the Calculator class i.e. create a calculator object.
        Calculator c = new Calculator();
        //call the first method to run in the calculator object we created.
        c.getFirstNumber();
    }

    private void getFirstNumber(){
        //Creates a separated space to display current value of memory.
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Memory: " + memory + ANSI_RESET);
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println();
        System.out.println("Enter first number:");
        //get first number from the user.
        String input = scn.nextLine();
        //if the user has entered the memory recall command set the first number to whatever is currently
        //stored in the memory variable.
        if(input.equalsIgnoreCase("mr")){
            firstNumber = memory;
        }
        //if the user has entered the memory clear command set the value of memory to 0.
        else if(input.equalsIgnoreCase("mc")){
            memory = 0;
            //once we have reset the value of memory go back and ask for the
            //first number again.
            getFirstNumber();
        }
        else {
            //if all the above conditions failed, get the first number and then go to the
            //get operand method.
            firstNumber = Double.parseDouble(input);
        }
        getOperand();
    }

    private void getOperand(){
        //Creates a separated space to display current value of memory.
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Memory: " + memory + ANSI_RESET);
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println();
        //ask for the operator to be used.
        System.out.println("Please enter the operand you wish to use:");
        operand = scn.nextLine();
        //check to see if the operand entered by the user will require a second number for the calculation.
        if(!requiresSecond()){
            //if it doesn't require a second number then perform the calculation.
            performCalculation();
        }
        //if it does need a second number call the next method.
        else {
            getSecondNumber();
        }
    }

    private void getSecondNumber(){
        //Creates a separated space to display current value of memory.
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Memory: " + memory + ANSI_RESET);
        System.out.println(ANSI_GREEN + "--------------------------" + ANSI_RESET);
        System.out.println();
        //prints out the current calculation as a visual cue to the user.
        //might want to format this to make it clear?
        System.out.println(firstNumber + " " + operand);
        //request the second number.
        System.out.println("Enter second number:");
        String input = scn.nextLine();
        //if the user entered the memory recall command.
        if(input.equalsIgnoreCase("mr")){
            //set the second number to the value in the memory.
            secondNumber = memory;
        }
        else {
            //get the value entered by the user and assign it to the second number variable
            secondNumber = Double.parseDouble(input);
        }
        //perform the calculation with the values we have.
        performCalculation();
    }

    private void performCalculation(){
        //check again to see if this type of calculation uses one or two numbers.
        if(requiresSecond()){
            //if it uses two numbers display the calculation in this format.
            System.out.println(firstNumber + " " + operand + " " + secondNumber);
        }
        else {
            //otherwise display the calculation in this format.
            System.out.println(operand + " of " + firstNumber);
        }
        //switch statement to determine which calculation to perform based on the
        //operand entered by the user.
        switch(operand){
            //if the operand is a +
            case "+":
                result = firstNumber + secondNumber;
                System.out.println(result);
                break;

            case "-":
                //if the operand is a -
                result = firstNumber - secondNumber;
                System.out.println(result);
                break;

            case "/":
                //if the operand is a /
                result = firstNumber / secondNumber;
                System.out.println(result);
                break;

            case "*":
                //if the operand is a *
                result = firstNumber * secondNumber;
                System.out.println(result);
                break;

            case "pow":
                //if the operand is 'pow' the use the Java Math library to calculate the power
                result = Math.pow(firstNumber, secondNumber);
                System.out.println(result);
                break;

            case "sqrt":
                //if the operand is square root, use the java Math library to get the
                // square root of the first number - this type of calculation does not
                //need a second number
                result = Math.sqrt(firstNumber);
                System.out.println(result);
                break;

            case "sq":
                //if the operand is square, multiply the first
                // number by itself - this type of calculation does not
                //need a second number
                result = firstNumber * firstNumber;
                System.out.println(result);
                break;

            case "rec":
                //if the operand is 'reciprocal' then divide 1 by the first number
                //this calculation does not need a second number as the calculation
                //always divides 1 by the number entered.
                result = 1 / firstNumber;
                System.out.println(result);
                break;

            case "m+":
                //Take whatever is currently in memory and add the value of first number to it.
                memory += firstNumber;
                getOperand();
                break;

            case "m-":
                //Take whatever is currently in memory and subtract the value of first number to it.
                memory -= firstNumber;
                getOperand();
                break;

            case "mc":
                //set the value of memory to 0.
                memory = 0.0;
                System.out.println(result);
                break;


        }
        //at this point the calculation has been completed and the result has been displayed to the
        //user, ask them if they want to perform another calculation, using the result from the
        //previous calculation as the first number.
        System.out.println("Do you want to perform another calculation on this result?");

        if(scn.nextLine().equalsIgnoreCase("y")){
            //if the user says they do want to perform another calculation.
            //set the value of first number to the result of the previous calculation.
            firstNumber = result;
            //go straight to get operand as we already have the first number
            getOperand();
        }
        else {
            //user does not want to perform a calculation using the result of the previous calculation
            //start again - get a new first number.
            getFirstNumber();
        }
    }

    //helper method to determine which operands require a second number.
    private boolean requiresSecond(){
        //if any of the cases are matched - return false.
        switch(operand){
            case "sqrt":
            case "sq":
            case "rec":
            case "m+":
            case "m-":
                return false;
        }
        //we will only get here if none of the cases matched, in which case return true
        //as we will need a second number.
        return true;
    }
}
