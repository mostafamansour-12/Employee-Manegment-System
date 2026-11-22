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
        if (!isIdUnique(d.getDepartmentId())){
            return;
        }
        if (!isNameUnique(d.getDepartmentName())){
            return;
        }
        departments.add(d);
    }

    public void delDepartment(int id){
        for (Department d : departments){
            if (d.getDepartmentId() == id){
                departments.remove(d);
            }
        }
    }

    public boolean isIdUnique(int id){
        for(Department d : departments){
            if (d.getDepartmentId() == id){
            return false;
            }
        }
        return true;
    }

    public boolean isNameUnique(String name){
        for(Department d : departments){
            if (d.getDepartmentName() == name){
            return false;
            }
        }
        return true;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
