package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

import java.sql.Timestamp;

/**
 * Created by phil_ on 13-06-2017.
 */

public class Order extends SugarRecord {
    private int order_id;
    private Author author;
    private Timestamp created_at, updated_at, deleted_at, approved, disapproved;
    private Provider provider;
    private String description, approved_by, disapproved_by;
    private Item[] items;
    private double sub_total, iva, total;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    public String getDisapproved_by() {
        return disapproved_by;
    }

    public void setDisapproved_by(String disapproved_by) {
        this.disapproved_by = disapproved_by;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order(int order_id, Author author, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, Timestamp approved, Timestamp disapproved, Provider provider, String description, String approved_by, String disapproved_by, Item[] items, double sub_total, double iva, double total) {

        this.order_id = order_id;
        this.author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.approved = approved;
        this.disapproved = disapproved;
        this.provider = provider;
        this.description = description;
        this.approved_by = approved_by;
        this.disapproved_by = disapproved_by;
        this.items = items;
        this.sub_total = sub_total;
        this.iva = iva;
        this.total = total;
    }

    public Order() {

    }
}
