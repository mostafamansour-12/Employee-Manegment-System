package service;

import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author Mostafa
 */
public class EmployeeManager {
    private ArrayList<Employee> employee = new ArrayList<>();

    public void addEmployee(Employee e){
        if (!isIdUnique(e.id)){
            return;
        }
        employee.add(e);
    }

    public void delEmployee(int id){
        for (Employee e : employee){
            if (e.getId() == id){
                employee.remove(e);
            }
        }
    }

    

    public boolean isIdUnique(int id){
        for(Employee e : employee){
            if (e.getId() == id){
            return false;
            }
        }
        return true;
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
    }
}
