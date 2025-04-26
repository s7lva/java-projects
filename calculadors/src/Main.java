import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao;
        double resultado, num1, num2;

        List<String> Operacoes = new ArrayList<>();


        Operacoes.add("--Calculadora--");
        Operacoes.add("1. Soma+");
        Operacoes.add("2 , subtracao-");
        Operacoes.add("3 ,multiplicacao*");
        Operacoes.add("4 , divisao%");
        Operacoes.add("5 ,sair");


        while (true) {
            // Imprime as opções
            for (String op : Operacoes) {
                System.out.println(op);
            }

            System.out.println("Escolha uma opção de (0-5)");
            sc.nextInt();


            if (resultado == 5) {
                System.out.println("saindo.....");
                return;// termina o programa
            }

            System.out.println("Digite o primeiro valor: ");
            num1 = sc.nextDouble();

            System.out.println("Digite o segundo valor: ");
            num2 = sc.nextDouble();


            switch (opcao) {
                case 1:
                    resultado = num1 + num2;
                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    resultado = num1 - num2;
                    System.out.println("Resultado: " + resultado);
                    break;

                case 3:
                    resultado = num2 * num1;
                    System.out.println("Resultado: " + resultado);
                    break;

                case 4:
                    if (num2 != 0) {
                        resultado = num1 % num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    } else {
                        System.out.println("Impossivel dividir por 0");
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");


            }
            System.out.println();
        }
        sc.close();
    }
}