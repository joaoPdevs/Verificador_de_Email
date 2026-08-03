package Funcionalidade;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class menu {

    // Metodo para exibir o menu e receber a opção do usuário
    public static void ExibirMenu() {
        Scanner leia = new Scanner(System.in, StandardCharsets.UTF_8);
        int opcao = -1;
        String opcaolink = "";

        while (opcao != 2) {
            System.out.println("\n=== Verificador de Mensagens ===");
            System.out.println("1. Insira uma mensagem para ser analisado: ");
            System.out.println("2. Encerrar Programa");
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
                    boolean valido = Analisar.validarFormatoEmail(textoEmAnalise);

                    if(valido == true){
                    int resultado = Analisar.analisarEmail(textoEmAnalise);

                    System.out.println("Score de perigo da mensagem: " + resultado);


                    while (!opcaolink.equals("N")){
                        System.out.println("Deseja analisar um link presente na mensagem? (Y/N)");

                        switch (leia.nextLine()) {
                            case "Y":
                            case "y":
                                opcaolink = "Y";
                                System.out.println("Digite o link a ser analisado: ");
                                String linkEmAnlise = leia.nextLine();
                                System.out.println("\nLink recebido com sucesso.");
                                System.out.println("Texto Recebido: " + linkEmAnlise);

                                resultado = Analisar.analisarLink(linkEmAnlise) + resultado;
                                System.out.println("O score atual de perigo da sua mensagem é: " + resultado);

                                break;
                            case "N":
                            case "n":
                                opcaolink = "N";
                                System.out.println("O score final de perigo da sua mensagem é: " + resultado + ", sendo classificada como " + ExibirGrau.DefinirGrau(resultado));
                                resultado = 0;

                                break;

                            default:
                                opcaolink = "-1";
                                System.out.println("Opção Inválida. Tente novamente.\n");
                                break;
                        }
                    }

                    break;

                }
                else{
                    System.out.println("A mensagem não cumpre o formato de comunicação da empresa!");
                    break;
                }

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