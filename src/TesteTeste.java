import java.util.Scanner;
import Funcionalidade.analisar;

public class https://medium.com/@habbema/java-hello-world-6dc92ce90a63TesteTeste {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite o conteudo do Email");
        String texto = leia.nextLine();

        int resultado = analisar.analisarEmail(texto);

        System.out.println(resultado);
    }
}
