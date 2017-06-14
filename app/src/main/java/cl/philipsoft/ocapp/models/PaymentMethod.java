package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

import java.sql.Timestamp;

public class PaymentMethod extends SugarRecord{
    private Long id;
    private String name;
    private Timestamp updated_at, created_at, deleted_at;

    public PaymentMethod() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public PaymentMethod(Long id, String name, Timestamp updated_at, Timestamp created_at, Timestamp deleted_at) {

        this.id = id;
        this.name = name;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }
}
