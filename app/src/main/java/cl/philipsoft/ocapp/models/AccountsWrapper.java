package cl.philipsoft.ocapp.models;

public class AccountsWrapper {
    private int per_page, total, current_page, last_page, from, to;
    private Account[] data;
    private String next_page_url;
    private String prev_page_url;

    public AccountsWrapper(int per_page, int total, Account[] data, int last_page, String next_page_url, int from, int to, String prev_page_url, int current_page) {
        this.per_page = per_page;
        this.total = total;
        this.data = data;
        this.last_page = last_page;
        this.next_page_url = next_page_url;
        this.from = from;
        this.to = to;
        this.prev_page_url = prev_page_url;
        this.current_page = current_page;
    }

    public AccountsWrapper() {

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

    public Account[] getData() {
        return data;
    }

    public void setData(Account[] data) {
        this.data = data;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
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

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
