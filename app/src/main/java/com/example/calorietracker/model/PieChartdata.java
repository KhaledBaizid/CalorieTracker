package com.example.calorietracker.model;

public class PieChartdata {
    private double totalFat;
    private double totalCarbs;
    private double totalProtein;

    public PieChartdata(double totalFat, double totalCarbs, double totalProtein) {
        this.totalFat = totalFat*9;
        this.totalCarbs = totalCarbs*4;
        this.totalProtein = totalProtein*4;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(double totalProtein) {
        this.totalProtein = totalProtein;
    }

    @Override
    public String toString() {
        return "PieChartdata{" +
                "totalFat=" + totalFat +
                ", totalCarbs=" + totalCarbs +
                ", totalProtein=" + totalProtein +
                '}';
    }
}
