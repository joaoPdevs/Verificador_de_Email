package Funcionalidade;

public class ExibirGrau {

    public static String DefinirGrau(int score) {

        String grau;

        if(score >= 0 && score <= 30) {
            grau = "Provavelmente Legítima";
        }
        else if(score > 30 && score < 100) {
            grau = "Suspeita";
        }
        else if(score >= 100) {
            grau = "Provavelmente é Golpe";
        }
        else {
            return "ERRO: Score Inválido.";
        }

        return grau;
    }
}