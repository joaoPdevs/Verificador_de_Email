package Funcionalidade;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class menu {

    private static String lerMensagem(Scanner leia) {
    StringBuilder mensagem = new StringBuilder();

    System.out.println("Digite o texto a ser analisado.");
    System.out.println("Quando terminar, digite FIM em uma nova linha:");

    while (true) {
        String linha = leia.nextLine();

        if (linha.equalsIgnoreCase("FIM")) {
            break;
        }

        mensagem.append(linha).append("\n");
    }

    return mensagem.toString();
}
    public static void ExibirMenu() {
        Scanner leia = new Scanner(System.in, StandardCharsets.UTF_8);
        int opcao = -1;
        String opcaolink = "";

        while (opcao != 2) {
            System.out.println("\n\n=== Verificador de Mensagens ===");
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
                    System.out.print("Digite o domínio que enviou a mensagem:\n ");
                    String dominio = leia.nextLine();
                    boolean dominio_valido = Analisar.validarDominio(dominio);
                    if(dominio_valido == true){

                    String textoEmAnalise = lerMensagem(leia);
                    System.out.println("\nTexto recebido com sucesso.");
                    System.out.println("Texto Recebido: " + textoEmAnalise);
                    boolean valido = Analisar.validarFormatoEmail(textoEmAnalise);

                    int resultado = Analisar.analisarEmail(textoEmAnalise);


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

                                break;
                            case "N":
                            case "n":
                                opcaolink = "N";
                                if(valido == false){
                                    System.out.println("\nAtenção!\nEssa mensagem não atende os padrões de comunicação da empresa(nome,setor e motivo).\nPor favor entre em contato com seu surpervisor antes de responder essa mensagem.");
                                }
                                else{
                                    System.out.println("Analisamos sua mensagem,e ela foi classificada como " + ExibirGrau.DefinirGrau(resultado));
                                    resultado = 0;
                                }
                                break;

                            default:
                                opcaolink = "-1";
                                System.out.println("Opção Inválida. Tente novamente.\n");
                                break;
                        }
                    }
                    opcaolink = "";
                    break;
                }

                else{
                    System.out.println("\nO domínio informado não é um domínio conhecido.\nVerifique se você inseriu o domínio corretamente. Caso contrário, entre em contato com seu supervisor antes de tomar qualquer medida.");    
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
