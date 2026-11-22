package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    private int id;
    private String name;
    private Department department;
    private int age;
    private String position;

    public Employee(int id, String name, Department department, int age, String position) {
        setId(id);
        setName(name);
        setDepartment(department);
        setAge(age);
        setPosition(position);
    }

    public abstract double calculateSalary();

    public abstract String getEmployeeType();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department must be selected");
        }
        this.department = department;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number");
        }
        this.age = age;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty");
        }
        this.position = position.trim();
    }
}