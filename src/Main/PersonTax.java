package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Utilities.TaxPlayer;

public class PersonTax {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		Locale.setDefault(Locale.US);

		System.out.print("Quantos contribuintes você vai digitar? ");
		String contributors = entrada.nextLine();
		int contributorValidated = Integer.parseInt(contributors);

		TaxPlayer persons[] = new TaxPlayer[contributorValidated];

		List<TaxPlayer> personsList = new ArrayList<>();

		for (int i = 0; i < persons.length; i++) {
			System.out.println("Digite os dados do " + (i + 1) + "º contribuinte!");

			System.out.print("Renda anual com salário: ");
			String salaryIncome = entrada.nextLine();
			double salaryIncomeValidated = Double.parseDouble(salaryIncome);

			System.out.print("Renda anual com prestação de serviço: ");
			String servicesIncome = entrada.nextLine();
			double servicesIncomeValidated = Double.parseDouble(servicesIncome);

			System.out.print("Renda anual com ganho de capital: ");
			String capitalIncome = entrada.nextLine();
			double capitalIncomeValidated = Double.parseDouble(capitalIncome);

			System.out.print("Gastos médicos: ");
			String heathSpending = entrada.nextLine();
			double heathSpendingValidated = Double.parseDouble(heathSpending);

			System.out.print("Gastos educacionais: ");
			String educationSpending = entrada.nextLine();
			double educationSpendingValidated = Double.parseDouble(educationSpending);

			persons[i] = new TaxPlayer(salaryIncomeValidated, servicesIncomeValidated, capitalIncomeValidated,
					heathSpendingValidated, educationSpendingValidated);
			personsList.add(persons[i]);
			System.out.println();
		}

		for (int i = 0; i < persons.length; i++) {
			System.out.println("Resumo do " + (i + 1) + " contribuinte");
			System.out.println(personsList.get(i).toString());
			System.out.println();
		}
	}

}
