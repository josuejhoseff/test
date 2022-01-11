package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.HourContract;
import entities.enums.Work;

public class Worker {
	private String name;
	private Work level;
	private double baseSalary;
	
	public Worker(String name, Work level, double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Work getLevel() {
		return level;
	}

	public void setLevel(Work level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	private List <HourContract>contracts = new ArrayList<>();
	public void addContrac(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContrac(HourContract contract) {
		contracts.remove(contract);
	}
	public double income( Integer month, Integer year) {
		double soma = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year= cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
		if(month == c_month && year==c_year) {
			soma= soma+c.totoalValue();
		}
			
		}
		return soma;
	}
	
	
}
