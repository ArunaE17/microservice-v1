package io.javabrains.moviecatalogservice.models;

public class book {
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString(){
        return "Ticket Status"+ Status;
    }
}
