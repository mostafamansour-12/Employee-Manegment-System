package model;

public class FullTimeEmployee extends Employee {

    private double basicSalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, Department department, int age, String position,
            double basicSalary, double bonus) {
        super(id, name, department, age, position);
        setBasicSalary(basicSalary);
        setBonus(bonus);
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary < 0) {
            throw new IllegalArgumentException("Basic salary cannot be negative");
        }
        this.basicSalary = basicSalary;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
        this.bonus = bonus;
    }
}