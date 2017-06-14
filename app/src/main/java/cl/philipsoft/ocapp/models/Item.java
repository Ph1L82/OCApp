package cl.philipsoft.ocapp.models;

import java.sql.Timestamp;

public class Item {
    private int id, quantity, account_budget_id, order_id;
    private double cost;
    private String name;
    private Timestamp created_at, updated_at, deleted_at;

    public Item(int id, int quantity, int account_budget_id, int order_id, double cost, String name, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at) {
        this.id = id;
        this.quantity = quantity;
        this.account_budget_id = account_budget_id;
        this.order_id = order_id;
        this.cost = cost;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Item() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAccount_budget_id() {
        return account_budget_id;
    }

    public void setAccount_budget_id(int account_budget_id) {
        this.account_budget_id = account_budget_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
}
