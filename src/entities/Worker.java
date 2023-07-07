package entities;

import enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<HourContract>();

    public Worker(){

    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public WorkerLevel getLevel() {

        return level;
    }

    public void setLevel(WorkerLevel level) {

        this.level = level;
    }

    public double getBaseSalary() {

        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {

        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {

        this.department = department;
    }

    public List<HourContract> getContracts() {

        return contracts;
    }

    public void addContract(HourContract contract){

        contracts.add(contract);
    }

    public void removeContract(HourContract contract){

        contracts.remove(contract);
    }

    public double income (int year, int month){
        double sum = baseSalary;
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/yyyy");
        LocalDate dateAux = LocalDate.of(year, month, 1);
        for(HourContract c : contracts){
            String aux1 = fmt1.format(c.getDate());
            String aux2 = fmt1.format(dateAux);

            if(aux1.equals(aux2)){
                sum += c.totalValue();
            }
        }

        return sum;
    }
}


