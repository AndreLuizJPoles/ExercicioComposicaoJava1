package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.next();
        Department department = new Department(departmentName);
        System.out.println("Enter worker data:");
        System.out.print("Name :");
        String name = sc.next();
        System.out.print("Level: ");
        String level = sc.next();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int numberContracts = sc.nextInt();
        for(int i = 0; i < numberContracts; i++){
            System.out.println("Enter contract #" + (i+1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.next();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (Hours): ");
            int hours = sc.nextInt();
            HourContract hourContract = new HourContract(date, valuePerHour,hours);
            worker.addContract(hourContract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.next();
        int month = Integer.parseInt(date.substring(0,2));
        int year = Integer.parseInt(date.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + date + ": "+  String.format("%.2f",worker.income(year, month)));

        sc.close();
    }
}