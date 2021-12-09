package employee_data;

public class Employee {

    private String forename;
    private String surname;
    private String username;
    private String password;
    private String department;
    private int service;
    private final boolean admin;

    public Employee(String forename, String surname, String username, String password, String department, int service, boolean admin) {
        this.forename = forename;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.department = department;
        this.service = service;
        this.admin = admin;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public boolean isAdmin() {
        return admin;
    }
}
