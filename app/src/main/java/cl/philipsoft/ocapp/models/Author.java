package cl.philipsoft.ocapp.models;

public class Author {
    private String name, company, department, email;

    public Author(String name, String company, String department, String email) {
        this.name = name;
        this.company = company;
        this.department = department;
        this.email = email;
    }

    public Author() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
