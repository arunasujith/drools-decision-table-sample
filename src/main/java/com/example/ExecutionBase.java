package com.example;

public class ExecutionBase {

    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isGovermentWorker() {
        return this.customer.getWorkType().equals(WorkType.GOVERNEMNT);
    }

    public boolean isRetired() {
        return this.customer.getAge() > 60;
    }

    public void execute(String result) {
        System.out.println(result);
    }
}
