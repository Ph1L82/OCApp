package cl.philipsoft.ocapp.models;

import java.sql.Timestamp;

/**
 * Created by phil_ on 13-06-2017.
 */

public class Order {
    private int id, approved_by, disapproved_by;
    private Author author;
    private Timestamp created_at, updated_at, deleted_at, approved, disapproved;
    private Provider provider;
    private String description;
    private Item[] items;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(int approved_by) {
        this.approved_by = approved_by;
    }

    public int getDisapproved_by() {
        return disapproved_by;
    }

    public void setDisapproved_by(int disapproved_by) {
        this.disapproved_by = disapproved_by;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public Timestamp getApproved() {
        return approved;
    }

    public void setApproved(Timestamp approved) {
        this.approved = approved;
    }

    public Timestamp getDisapproved() {
        return disapproved;
    }

    public void setDisapproved(Timestamp disapproved) {
        this.disapproved = disapproved;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order(int id, int approved_by, int disapproved_by, Author author, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, Timestamp approved, Timestamp disapproved, Provider provider, String description, Item[] items, double total) {

        this.id = id;
        this.approved_by = approved_by;
        this.disapproved_by = disapproved_by;
        this.author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.approved = approved;
        this.disapproved = disapproved;
        this.provider = provider;
        this.description = description;
        this.items = items;
        this.total = total;
    }

    public Order() {

    }
}
