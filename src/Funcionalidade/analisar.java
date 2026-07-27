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


    public static int analisarLink(String link) {
        int score=0;
        if(!link.contains("https://")) {//aumenta score de perigo por tokens ausentes.
            score += 40;
        }

}
