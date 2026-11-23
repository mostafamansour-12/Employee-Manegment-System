package service;

import java.util.ArrayList;
import model.Employee;
import io.FileHandler;

public class EmployeeManager {
    private ArrayList<Employee> employee = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    public EmployeeManager() {
        load();
    }

    public void addEmployee(Employee e){
        if (!isIdUnique(e.getId())){
            return;
        }
        employee.add(e);
        save();
    }

    public void deleteEmployee(int id){
        for (int i = 0; i < employee.size(); i++){
            if (employee.get(i).getId() == id){
                employee.remove(i);
                break;
            }
        }
        save();
    }

    public void updateEmployee(int oldId, Employee e){
        for (int i = 0; i < employee.size(); i++){
            if (employee.get(i).getId() == oldId){
                employee.set(i, e);
                break;
            }
        }
        save();
    }

    public Employee getEmployeeById(int id){
        for (Employee e : employee){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public ArrayList<Employee> searchByName(String name){
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employee){
            if (e.getName().toLowerCase().contains(name.toLowerCase())){
                filteredEmployees.add(e);
            }
        }
        return filteredEmployees;
    } 

    public ArrayList<Employee> filterByDepartment(String departmentName){
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employee){
            if (e.getDepartment().getDepartmentName().equals(departmentName)){
                filteredEmployees.add(e);
            }
        }
        return filteredEmployees;
    }

    public boolean isIdUnique(int id){
        for(Employee e : employee){
            if (e.getId() == id){
            return false;
            }
        }
        return true;
    }

    private void save(){
        fileHandler.saveEmployees(employee);
    }

    private void load(){
        employee = fileHandler.loadEmployees();
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
    }
}
