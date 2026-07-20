package Funcionalidade;

public class analisar {
    public static int analisarEmail(String assunto){
        int score=0;

        if(assunto.contains("pix")){
            score+=10;
        }
        if(assunto.contains("código de verificação")){
            score+=20;
        }
        return score;
    }

}
