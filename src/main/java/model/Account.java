package model;

import java.util.Objects;

public class Account {

    private String Phone;
    private String Fax;
    private String Website;
    private String Employees;

    // POJO - plain old java object
    public Account() {
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getEmployees() {
        return Employees;
    }

    public void setEmployees(String employees) {
        Employees = employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Phone.equals(account.Phone) && Fax.equals(account.Fax) && Website.equals(account.Website) && Employees.equals(account.Employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Phone, Fax, Website, Employees);
    }

}
