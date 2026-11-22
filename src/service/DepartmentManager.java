package service;

import java.util.ArrayList;
import model.Department;

/**
 *
 * @author Mostafa
 */
public class DepartmentManager {
    private ArrayList<Department> departments = new ArrayList<>();

    public void addDepartment(Department d){
        if (!isIdUnique(d.id)){
            return;
        }
        if (!isNameUnique(d.name)){
            return;
        }
        departments.add(d);
    }

    public void delDepartment(int id){
        for (Department d : departments){
            if (d.getId() == id){
                departments.remove(d);
            }
        }
    }

    public boolean isIdUnique(int id){
        for(Department d : departments){
            if (d.getId() == id){
            return false;
            }
        }
        return true;
    }

    public boolean isNameUnique(String name){
        for(Department d : departments){
            if (d.getName() == name){
            return false;
            }
        }
        return true;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
