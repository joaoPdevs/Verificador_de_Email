package Funcionalidade;
import java.util.Scanner;

public class menu {

    // Metodo para exibir o menu e receber a opção do usuário
    public static void ExibirMenu() {
        Scanner leia = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 2) {
            System.out.println("\n=== Verificador de E-mail ===");
            System.out.println("1. Inserir um e-mail para ser analisado");
            System.out.println("2. Encerrar Programa");
            System.out.print("Opção: ");

            // Valida se foi digitado um número inteiro
            if (leia.hasNextInt()) {
                opcao = leia.nextInt();
                leia.nextLine(); // Limpa o "Enter" pendente
            } else {
                System.out.println("\nOpção Inválida. Insira apenas números inteiros.");
                leia.nextLine(); // Descarta a entrada inválida
                continue;
            }

            // Direciona a ação da opção
            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto a ser analisado: ");
                    String textoEmAnalise = leia.nextLine();
                    System.out.println("\nTexto recebido com sucesso.");
                    System.out.println("Texto Recebido: " + textoEmAnalise);

                    int resultado = Analisar.analisarEmail(textoEmAnalise);

                    System.out.println(resultado);

                    break;

                case 2:
                    System.out.println("\nEncerrando o programa...");
                    break;

                default:
                    System.out.println("\nOpção Inválida. Escolha 1 ou 2.");
                    break;
            }
        }
        leia.close();
    }
}