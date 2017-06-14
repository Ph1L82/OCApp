package cl.philipsoft.ocapp.models;

import java.sql.Timestamp;

public class Provider {
    private int id;
    private String rut, address, phone, company_name, email;
    private Timestamp created_at, updated_at, deleted_at;

    public Provider(int id, String rut, String address, String phone, String company_name, String email, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at) {
        this.id = id;
        this.rut = rut;
        this.address = address;
        this.phone = phone;
        this.company_name = company_name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public Provider() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
