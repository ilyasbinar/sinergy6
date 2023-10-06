package org.example;

public class Employee {
    private String id;
    private Long salary;

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, Long salary) {
        this.id = id;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
