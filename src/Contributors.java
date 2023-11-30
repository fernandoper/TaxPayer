import entities.TaxPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Contributors {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPlayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes voce vai digitar? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Digite os dados do " + (i + 1) + "o contribuinte: ");
            System.out.print("Renda anual com salario: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestacao de servico: ");
            double serviceIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPlayer tp = new TaxPlayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending);
            list.add(tp);
        }

        System.out.println();
        int counter = 1;

        for (TaxPlayer tp : list) {
            System.out.println("Resumo do " + counter + "o contribuinte: ");
            System.out.println("Imposto bruto total: " + String.format("%.2f", tp.grossTax()));
            System.out.println("Abatimento: " + String.format("%.2f", tp.taxRebate()));
            System.out.println("Imposto devido: " + String.format("%.2f", tp.netTax()));
            counter ++;
            System.out.println();
        }
        sc.close();
    }
}

