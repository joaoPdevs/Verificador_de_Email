package Funcionalidade;

public class analisar {
    public static int analisarEmail(String assunto){
        int score=0;

       String[] palavras = {
            "pix",
            "urgente",
            "clique aqui",
            "desbloquear",
            "conta",
            "senha",
            "banco",
            "confirme",
            "última chance",
            "exclusivo",
            "grátis",
            "imperdível",
            "prêmio",
            "você ganhou",
            "sorteado",
            "confirme seus dados",
            "atualize seu cadastro",
            "verifique sua conta",
            "pagamento pendente",
            "liberação imediata",
            "sem burocracia",
            "lucro garantido",
            "renda extra",
            "100% garantido",
            "oferta por tempo limitado",
            "aja agora",
            "não perca"
        };

        assunto = assunto.toLowerCase();

        for (String palavra : palavras) {
            if (assunto.contains(palavra.toLowerCase())) {
                score += 10;
            }
        }        

        return score;
    }

}
