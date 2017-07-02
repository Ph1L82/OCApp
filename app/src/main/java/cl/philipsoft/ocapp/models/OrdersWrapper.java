package cl.philipsoft.ocapp.models;

/**
 * Created by phil_ on 01-07-2017.
 */

public class OrdersWrapper {
    private int per_page, total, current_page, last_page, from, to;
    private Order[] data;
    private String next_page_url;
    private String prev_page_url;

    public OrdersWrapper(int per_page, int total, int current_page, int last_page, int from, int to, Order[] data, String next_page_url, String prev_page_url) {
        this.per_page = per_page;
        this.total = total;
        this.current_page = current_page;
        this.last_page = last_page;
        this.from = from;
        this.to = to;
        this.data = data;
        this.next_page_url = next_page_url;
        this.prev_page_url = prev_page_url;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Order[] getData() {
        return data;
    }

    public void setData(Order[] data) {
        this.data = data;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public OrdersWrapper() {

    }
}
