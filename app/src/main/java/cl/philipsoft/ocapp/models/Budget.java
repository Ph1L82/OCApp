package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

import java.sql.Date;

/**
 * Created by phil_ on 13-06-2017.
 */

public class Budget extends SugarRecord {
    private int department_id;
    private String department;
    private Date begins, ends;
    private double totalAssigned, totalBalance;
    private AccountBudget[] accounts;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBegins() {
        return begins;
    }

    public void setBegins(Date begins) {
        this.begins = begins;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }

    public double getTotalAssigned() {
        return totalAssigned;
    }

    public void setTotalAssigned(double totalAssigned) {
        this.totalAssigned = totalAssigned;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public AccountBudget[] getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountBudget[] accounts) {
        this.accounts = accounts;
    }

    public Budget(int department_id, String department, Date begins, Date ends, double totalAssigned, double totalBalance, AccountBudget[] accounts) {

        this.department_id = department_id;
        this.department = department;
        this.begins = begins;
        this.ends = ends;
        this.totalAssigned = totalAssigned;
        this.totalBalance = totalBalance;
        this.accounts = accounts;
    }

    public Budget() {

    }
}
