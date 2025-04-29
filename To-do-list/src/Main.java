import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<String> bloconotas = new ArrayList<>();

        bloconotas.add("1 (adicionar)");
        bloconotas.add("2 (remover)");
        bloconotas.add("3 (ver lista)");
        bloconotas.add("4 (sair do bloco de notas)");


        List<String> notas = new ArrayList<>();

        int opcao;

        do {
            // Exibir as opções para o utilizador
            System.out.println("Escolha uma das opções:");
            for (String opcaoLista : bloconotas) {
                System.out.println(opcaoLista);
            }

            // Ler a opção escolhida pelo utilizador
            opcao = sc.nextInt();
                                                                                                  sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o que pretende adicionar");
                    String nota = sc.next();
                    bloconotas.add(nota);
                    break;
                case 2:

                    System.out.println("Digite o que remover");
                    String delete = sc.next();
                    if (bloconotas.contains(delete)) {
                        bloconotas.remove(delete);
                        break;
                    } else {
                        System.out.println("não foi possivel remover");
                    }
                case 3:
                    System.out.println("Notas do bloco de notas");
                    if (notas.isEmpty()) {
                        System.out.println("não existe notas a imprimir");
                    } else {
                        for (String itens : bloconotas) {
                            System.out.println(itens);
                        }

                    }
                    break;

                case 4:
                    System.out.println("saindo......");
                    break;
                    default:
                        System.out.println("opção invalida , tente novamente");


            }
        } while (opcao != 4);

        sc.close();
    }
}