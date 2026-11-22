package model;

public class PartTimeEmployee extends Employee {

    private double hourlyPayementRate;
    private double workedHoursMonthly;

    public PartTimeEmployee(int id, String name, Department department, int age, String position,
            double hourlyPayementRate, double workedHoursMonthly) {
        super(id, name, department, age, position);
        setHourlyPayementRate(hourlyPayementRate);
        setWorkedHoursMonthly(workedHoursMonthly);
    }

    @Override
    public double calculateSalary() {
        return hourlyPayementRate * workedHoursMonthly;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }

    public double getHourlyPayementRate() {
        return hourlyPayementRate;
    }

    public double getWorkedHoursMonthly() {
        return workedHoursMonthly;
    }

    public void setHourlyPayementRate(double hourlyPayementRate) {
        if (hourlyPayementRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative");
        }
        this.hourlyPayementRate = hourlyPayementRate;
    }

    public void setWorkedHoursMonthly(double workedHoursMonthly) {
        if (workedHoursMonthly < 0) {
            throw new IllegalArgumentException("Worked hours cannot be negative");
        }
        this.workedHoursMonthly = workedHoursMonthly;
    }
}
