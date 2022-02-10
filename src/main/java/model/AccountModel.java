package model;

import java.util.Objects;

public class AccountModel {

    String AccountName;
    String Phone;
    String Website;
    int Employees;
    String Type;
    String Industry;

    public AccountModel() {
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public int getEmployees() {
        return Employees;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountModel account = (AccountModel) o;
        return Employees == account.Employees && Objects.equals(AccountName, account.AccountName) && Objects.equals(Phone, account.Phone) && Objects.equals(Website, account.Website) && Objects.equals(Type, account.Type) && Objects.equals(Industry, account.Industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountName, Phone, Website, Employees, Type, Industry);
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountName='" + AccountName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Website='" + Website + '\'' +
                ", Employees=" + Employees +
                ", Type='" + Type + '\'' +
                ", Industry='" + Industry + '\'' +
                '}';
    }

}
