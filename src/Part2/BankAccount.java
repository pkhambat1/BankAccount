package Part2;

import Part1.Measurable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BankAccount extends Part2.Measurable {
	private float balance;
	private float rate;
	
	public BankAccount(float balance, float r) {
		this.balance = balance;
		this.rate = r;
	}
	
	public static void main(String[] args) {
		Part2.BankAccount ba1 = new BankAccount(120000, 12);
		Part2.BankAccount ba2 = new BankAccount(130000, 10);
		Part2.BankAccount ba3 = new BankAccount(15000, 12);
		int compareBoth = ba1.compareTo(ba2);
		if (compareBoth == 1) {
			System.out.println("ba1 > ba2");
		} else if (compareBoth == -1) {
			System.out.println("ba1 < ba2");
		} else if (compareBoth == 0) {
			System.out.println("ba1 == ba2");
		}
		List<Part2.BankAccount> bankAccounts = new ArrayList<>(Arrays.asList(ba1, ba2, ba3));
		Collections.sort(bankAccounts);
		for (int i = 0; i < bankAccounts.size(); i++) {
			System.out.print(bankAccounts.get(i).getMeasure() + ", ");
		}
		System.out.println();
		float average = Part2.Measurable.average(bankAccounts);
		System.out.println("Average = " + average);
	}
	
	private void processYear() {
		float interest = this.balance * this.rate;
		this.balance = this.balance + interest;
	}
	
	public void processNYears(int n) {
		int i = 0;
		while (i < n) {
			processYear();
			i++;
		}
	}
	
	@Override
	public float getMeasure() {
		return balance;
	}
}
