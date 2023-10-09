package org.example;

import java.util.List;

public class Employee {
    private String id;
    private String name;

    private Long salary;

    private List<String> noHp;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public List<String> getNoHp() {
        return noHp;
    }

    public void setNoHp(List<String> noHp) {
        this.noHp = noHp;
    }
}
