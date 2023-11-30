package entities;

public class TaxPlayer {
    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPlayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax(double salaryIncome){
        if (this.salaryIncome < 36000.00){
            return 0;
        } else if (this.salaryIncome > 60000.00){
            return salaryIncome * 0.2;
        } else {
            return salaryIncome * 0.1;
        }
    }

    public double servicesTax (double serviceIncome){
        if (this.serviceIncome > 0){
            return serviceIncome * 0.15;
        } else {
            return 0;
        }
    }

    public double capitalTax(double capitalIncome){
        if (this.capitalIncome > 0) {
            return capitalIncome * 0.2;
        } else {
            return 0;
        }
    }

    public double grossTax(){
        return salaryTax(salaryIncome) + servicesTax(serviceIncome) + capitalTax(capitalIncome);
    }

    public double taxRebate(){
        if ((healthSpending + educationSpending) < (grossTax() * 0.3) ) {
            return (healthSpending + educationSpending);
        } else {
            return grossTax() * 0.3;
        }
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }

}
