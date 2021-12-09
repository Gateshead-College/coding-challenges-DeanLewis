package employee_data;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<Employee> emps = new ArrayList<>();

    public static void main(String[] args) {
        Login l = new Login();
        l.createEmployees();
        l.login();
    }

    private void createEmployees() {
        emps.add(new Employee("Dean", "Lewis", "dLew", "password", "Product Development", 6, true));
        emps.add(new Employee("Steve", "Lumsden", "sLum", "password1", "Staff Development", 6, false));
        emps.add(new Employee("Lee", "Curtis", "lCur", "password2", "Sales", 6, false));
        emps.add(new Employee("Monika", "Innes", "mInn", "password3", "Recruitment", 6, false));
        emps.add(new Employee("Jon", "Todd", "jTod", "password4", "Product Delivery", 6, false));
    }

    private void login() {
        System.out.println("Hi, please enter your username to continue:");
        String un = new Scanner(System.in).nextLine();
        System.out.println("and now your password:");
        String pw = new Scanner(System.in).nextLine();
        for(Employee e : emps){
            if(e.getUsername().equalsIgnoreCase(un) && e.getPassword().equals(pw)){
                if(e.isAdmin()){
                    new MainMenu(emps, e);
                }
                else {
                    new MainMenu(new ArrayList<>(), e);
                }
            }
            else if(emps.indexOf(e) == emps.size()){
                System.out.println("Invalid username and/or password, please try again.");
            }
        }
        login();
    }



}
