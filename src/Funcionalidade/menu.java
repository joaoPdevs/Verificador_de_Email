package Funcionalidade;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class menu {

    // Metodo para exibir o menu e receber a opção do usuário
    public static void ExibirMenu() {
        Scanner leia = new Scanner(System.in, StandardCharsets.UTF_8);
        int opcao = -1;

        while (opcao != 2) {
            System.out.println("\n=== Verificador de E-mail ===");
            System.out.println("1. Inserir um e-mail para ser analisado");
            System.out.println("2. Inserir um link para ser analisado");
            System.out.println("3. Encerrar Programa");
            System.out.print("Opção: ");

            
            if (leia.hasNextInt()) {
                opcao = leia.nextInt();
                leia.nextLine();
            } else {
                System.out.println("\nOpção Inválida. Insira apenas números inteiros.");
                leia.nextLine();
                continue;
            }

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
                    System.out.println("Digite o link a ser analisado: ");
                    String linkEmAnlise = leia.nextLine();
                    System.out.println("\nLink recebido com sucesso.");
                    System.out.println("Texto Recebido: " + linkEmAnlise);

                    int resultadoLink = Analisar.analisarLink(linkEmAnlise);
                    System.out.println(resultadoLink);

                case 3:
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