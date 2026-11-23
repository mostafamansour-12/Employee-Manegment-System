package io;

import java.io.*;
import java.util.ArrayList;
import model.Employee;
import model.Department;

public class FileHandler {
    private String employeeFilePath = "employee.dat";
    private String departmentFilePath = "department.dat";

    public void saveEmployees(ArrayList<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(employeeFilePath))) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Employee> loadEmployees() {
        File file = new File(employeeFilePath);
        if (!file.exists()) {
            return new ArrayList<Employee>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Employee>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        return new ArrayList<Employee>();
    }

    public void saveDepartments(ArrayList<Department> departments) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(departmentFilePath))) {
            out.writeObject(departments);
        } catch (IOException e) {
            System.out.println("Error saving departments: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Department> loadDepartments() {
        File file = new File(departmentFilePath);
        if (!file.exists()) {
            return new ArrayList<Department>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Department>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading departments: " + e.getMessage());
        }
        return new ArrayList<Department>();
    }
}