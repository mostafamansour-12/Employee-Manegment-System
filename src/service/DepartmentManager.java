package service;

import java.util.ArrayList;
import model.Department;
import io.FileHandler;

public class DepartmentManager {
    private ArrayList<Department> departments = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    public DepartmentManager() {
        load();
    }

    public void addDepartment(Department d){
        if (!isIdUnique(d.getDepartmentId())){
            return;
        }
        if (!isNameUnique(d.getDepartmentName())){
            return;
        }
        departments.add(d);
        save();
    }

    public void deleteDepartment(int id){
        for (int i = 0; i < departments.size(); i++){
            if (departments.get(i).getDepartmentId() == id){
                departments.remove(i);
                break;
            }
        }
        save();
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

    private void save(){
        fileHandler.saveDepartments(departments);
    }

    private void load(){
        departments = fileHandler.loadDepartments();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
