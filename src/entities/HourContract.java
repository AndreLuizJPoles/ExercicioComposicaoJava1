package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(String date,Double valuePerHour, Integer hours) {
        this.valuePerHour = valuePerHour;
        this.hours = hours;
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public HourContract (){

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public Double getValuePerHour() {

        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {

        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {

        return hours;
    }

    public void setHours(Integer hours) {

        this.hours = hours;
    }

    public double totalValue(){

        return hours * valuePerHour;
    }
}
