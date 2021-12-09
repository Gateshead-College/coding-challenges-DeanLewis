package employee_data;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<Employee> emps;
    private Employee emp;

    public MainMenu(ArrayList<Employee> emps, Employee emp) {
        this.emps = emps;
        this.emp = emp;
        if (emps.isEmpty()) {
            menu();
        } else {
            adminMenu();
        }
    }

    private void menu() {
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println("      Welcome back " + emp.getForename());
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println("Please select an option from the list below:");
        System.out.println(ANSI_GREEN + "1 " + ANSI_RESET + " - View my details");
        System.out.println(ANSI_RED + "2 " + ANSI_RESET + " - Logout");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if (choice == 1) {
            displayDetails(emp);
            menu();
        } else if (choice == 2) {
            System.out.println("Signing out...");
            //do nothing and it will go back to login.
        } else {
            System.out.println("Invalid option selected, please try again.");
            menu();
        }
    }

    private void adminMenu() {
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println("      Welcome back " + emp.getForename());
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println("Please select an option from the list below:");
        System.out.println(ANSI_GREEN + "1 " + ANSI_RESET + " - View my details");
        System.out.println(ANSI_GREEN + "2 " + ANSI_RESET + " - View an Employees details");
        System.out.println(ANSI_RED + "3 " + ANSI_RESET + " - Logout");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if (choice == 1) {
            displayDetails(emp);
            adminMenu();
        } else if (choice == 2) {
            displayEmployees();
            adminMenu();
        } else if (choice == 3) {
            System.out.println("Signing out...");
            //do nothing and it will go back to login.
        } else {
            System.out.println("Invalid option selected, please try again.");
            adminMenu();
        }
    }

    private void displayEmployees() {
        if (!emps.isEmpty()) {
            int x = 1;
            System.out.println("Select the employee from the list below");
            for (Employee e : emps) {
                System.out.println(x + " - " + ANSI_CYAN + e.getForename() + " " + e.getSurname() + ANSI_RESET);
                x++;
            }
            System.out.println(x + " - Go back");
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choice <= emps.size()) {
                employeeAdminMenu(choice);
            }
        } else {
            System.out.println("You do not have permission to do that.");
            System.out.println("Report yourself immediately for disciplinary action.");
            adminMenu();
        }
    }

    private void employeeAdminMenu(int choice) {
        Employee e = emps.get(choice - 1);
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println("    You are viewing  " + e.getForename() + " " + e.getSurname());
        System.out.println(ANSI_YELLOW + "-------------------------------" + ANSI_RESET);
        System.out.println();
        System.out.println("Select an option from below: ");
        System.out.println("1 - View employee details");
        System.out.println("2 - Edit employee details");
        System.out.println("3 - Delete employee record");
        System.out.println("4 - Go Back");
        handleChoice(e, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void handleChoice(Employee e, int choice) {
        switch (choice) {
            case 1 -> {
                displayDetails(e);
                employeeAdminMenu(emps.indexOf(e) + 1);
            }
            case 2 -> editDetails(e);
            case 3 -> deleteRecord(e);
            case 4 -> displayEmployees();
            default -> System.out.println("Invalid option provided, please try again");
        }
    }

    private void deleteRecord(Employee e) {
        System.out.println("Are you sure you want to delete the record of " + ANSI_CYAN + e.getForename() + " " + e.getSurname() + ANSI_RESET + "?");
        if(new Scanner(System.in).nextLine().equalsIgnoreCase("y")){
            System.out.println("Please enter your password to confirm:");
            if(new Scanner(System.in).nextLine().equals(emp.getPassword())){
                System.out.println("Deleting record now...");
                emps.remove(e);
            }
            else {
                System.out.println("Invalid password entered, aborting.");
            }
        }
        else {
            System.out.println("Very well, aborting.");
            displayEmployees();
        }
    }

    private void editDetails(Employee e) {
        System.out.println("Which field would you like to amend?");
        System.out.println("1 - Forename");
        System.out.println("2 - Surname");
        System.out.println("3 - Password");
        System.out.println("4 - Department");
        System.out.println("5 - Service");
        getNewValue(e, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void getNewValue(Employee e, int i) {
        switch (i) {
            case 1 -> updateForename(e);
            case 2 -> updateSurname(e);
            case 3 -> updatePassword(e);
            case 4 -> updateDepartment(e);
            case 5 -> updateService(e);
        }
    }

    private void updateService(Employee e) {
        System.out.println("The current value is: " + ANSI_CYAN + e.getService() + ANSI_RESET);
        System.out.println("Please enter the new value:");
        String newService = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + ANSI_CYAN + e.getService() + ANSI_RESET + " with " + ANSI_CYAN + newService + ANSI_RESET + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            e.setService(Integer.parseInt(newService));
        }
        System.out.println("Employees service has been changed to " + ANSI_CYAN + newService + ANSI_RESET);
        System.out.println("Would you like to edit more of this employees details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            editDetails(e);
        } else {
            displayEmployees();
        }
    }

    private void updateDepartment(Employee e) {
        System.out.println("The current value is: " + ANSI_CYAN + e.getDepartment() + ANSI_RESET);
        System.out.println("Please enter the new value:");
        String newDepartment = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + ANSI_CYAN + e.getDepartment() + ANSI_RESET + " with " + ANSI_CYAN + newDepartment + ANSI_RESET + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            e.setDepartment(newDepartment);
        }
        System.out.println("Employees department has been changed to " + ANSI_CYAN + newDepartment + ANSI_RESET);
        System.out.println("Would you like to edit more of this employees details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            editDetails(e);
        } else {
            displayEmployees();
        }
    }

    private void updatePassword(Employee e) {
        System.out.println("The current value is: " + ANSI_CYAN + e.getPassword() + ANSI_RESET);
        System.out.println("Please enter the new value:");
        String newPassword = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + ANSI_CYAN + e.getPassword() + ANSI_RESET + " with " + ANSI_CYAN + newPassword + ANSI_RESET + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            e.setPassword(newPassword);
        }
        System.out.println("Employees password has been changed to " + ANSI_CYAN + newPassword + ANSI_RESET);
        System.out.println("Would you like to edit more of this employees details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            editDetails(e);
        } else {
            displayEmployees();
        }

    }

    private void updateSurname(Employee e) {
        System.out.println("The current value is: " + ANSI_CYAN + e.getSurname() + ANSI_RESET);
        System.out.println("Please enter the new value:");
        String newSurname = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + ANSI_CYAN + e.getSurname() + ANSI_RESET + " with " + ANSI_CYAN + newSurname + ANSI_RESET + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            e.setSurname(newSurname);
        }
        System.out.println("Employees surname has been changed to " + ANSI_CYAN + newSurname + ANSI_RESET);
        System.out.println("Would you like to edit more of this employees details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            editDetails(e);
        } else {
            displayEmployees();
        }
    }

    private void updateForename(Employee e) {
        System.out.println("The current value is: " + ANSI_CYAN + e.getForename() + ANSI_RESET);
        System.out.println("Please enter the new value:");
        String newForename = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + ANSI_CYAN + e.getForename() + ANSI_RESET + " with " + ANSI_CYAN + newForename + ANSI_RESET + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            e.setForename(newForename);
        }
        System.out.println("Employees forename has been changed to " + ANSI_CYAN + newForename + ANSI_RESET);
        System.out.println("Would you like to edit more of this employees details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            editDetails(e);
        } else {
            displayEmployees();
        }
    }

    private void displayDetails(Employee e) {
        System.out.println("Forename: " + ANSI_CYAN + e.getForename() + ANSI_RESET);
        System.out.println("Surname: " + ANSI_CYAN + e.getSurname() + ANSI_RESET);
        System.out.println("Username: " + ANSI_CYAN + e.getUsername() + ANSI_RESET);
        System.out.println("Password: " + ANSI_CYAN + e.getPassword() + ANSI_RESET);
        System.out.println("Department: " + ANSI_CYAN + e.getDepartment() + ANSI_RESET);
        System.out.println("Years Service: " + ANSI_CYAN + e.getService() + ANSI_RESET);
    }
}
