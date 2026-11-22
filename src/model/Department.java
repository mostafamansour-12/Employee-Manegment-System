package model;

import java.io.Serializable;

public class Department implements Serializable {

    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName) {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentId(int departmentId) {
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be a positive number");
        }
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        this.departmentName = departmentName.trim();
    }

    @Override
    public String toString() {
        return departmentName;
    }
}
