package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

import java.sql.Timestamp;

public class AccountBudget extends SugarRecord {
    private int account_id;
    private double balance, assigned;
    private Timestamp updated_at;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAssigned() {
        return assigned;
    }

    public void setAssigned(double assigned) {
        this.assigned = assigned;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public AccountBudget(int account_id, double balance, double assigned, Timestamp updated_at) {

        this.account_id = account_id;
        this.balance = balance;
        this.assigned = assigned;
        this.updated_at = updated_at;
    }

    public AccountBudget() {

    }
}
