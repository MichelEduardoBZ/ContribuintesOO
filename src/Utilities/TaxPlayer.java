package Utilities;

import java.text.DecimalFormat;

public class TaxPlayer {

	DecimalFormat df = new DecimalFormat("####,##0.00");
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double heathSpending;
	private Double educationSpending;

	public TaxPlayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double heathSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.heathSpending = heathSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHeathSpending() {
		return heathSpending;
	}

	public void setHeathSpending(Double heathSpending) {
		this.heathSpending = heathSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {

		double calcSalaryMonthly = this.getSalaryIncome() / 12;

		if (calcSalaryMonthly < 3000) {
			return 0;
		} else if (calcSalaryMonthly >= 3000 && calcSalaryMonthly < 5000) {
			return this.getSalaryIncome() * 0.1;
		} else {
			return this.getSalaryIncome() * 0.2;
		}
	}

	public Double servicesTax() {
		if (this.getServicesIncome() > 0) {
			return this.getServicesIncome() * 0.15;
		} else {
			return 0.0;
		}
	}

	public double capitalTax() {
		if (this.getCapitalIncome() > 0) {
			return this.getCapitalIncome() * 0.2;

		} else {
			return 0.0;
		}
	}

	public double grossTax() {
		return capitalTax() + servicesTax() + salaryTax();
	}

	public double taxRebate() {
		double spent = this.getEducationSpending() + this.getHeathSpending();
		double calcBrute = grossTax() * 0.3;

		if (spent > calcBrute) {
			return grossTax() - (grossTax() - calcBrute);
		} else {
			return grossTax() - (grossTax() - spent);
		}
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

	@Override
	public String toString() {
		return "Imposto bruto total: " + df.format(grossTax()) + "\n" + "Abatimento: " + df.format(taxRebate()) + "\n" + "Imposto devido "
				+ df.format(netTax());
	}

}
