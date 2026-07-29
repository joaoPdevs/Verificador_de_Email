package Funcionalidade;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class Analisar {

    private static String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    public static int analisarEmail(String assunto) {
        int score = 0;

        HashMap<String, Integer> palavras_golpes = new HashMap<>();

        palavras_golpes.put("pix", 38);
        palavras_golpes.put("urgente", 30);
        palavras_golpes.put("clique aqui", 35);
        palavras_golpes.put("desbloquear", 28);
        palavras_golpes.put("conta", 12);
        palavras_golpes.put("senha", 35);
        palavras_golpes.put("banco", 15);
        palavras_golpes.put("confirme", 25);
        palavras_golpes.put("última chance", 30);
        palavras_golpes.put("exclusivo", 12);
        palavras_golpes.put("grátis", 18);
        palavras_golpes.put("imperdível", 18);
        palavras_golpes.put("prêmio", 30);
        palavras_golpes.put("você ganhou", 40);
        palavras_golpes.put("sorteado", 32);
        palavras_golpes.put("confirme seus dados", 45);
        palavras_golpes.put("atualize seu cadastro", 40);
        palavras_golpes.put("verifique sua conta", 42);
        palavras_golpes.put("pagamento pendente", 38);
        palavras_golpes.put("liberação imediata", 35);
        palavras_golpes.put("sem burocracia", 25);
        palavras_golpes.put("lucro garantido", 45);
        palavras_golpes.put("renda extra", 28);
        palavras_golpes.put("100% garantido", 50);
        palavras_golpes.put("oferta por tempo limitado", 25);
        palavras_golpes.put("aja agora", 30);
        palavras_golpes.put("não perca", 20);

        assunto = normalizar(assunto);

        for (Map.Entry<String, Integer> entry : palavras_golpes.entrySet()) {
            String palavra = normalizar(entry.getKey());
            int peso = entry.getValue();

            if (assunto.contains(palavra)) {
                score += peso;
            }
        }

        return score;
    }

    public static int analisarLink(String link) {
        int score = 0;

        if (link == null || link.isBlank()) {
            return 100;
        }

        link = link.toLowerCase();

        if (!link.startsWith("https://")) {
            score += 40;
        }

        if (link.contains("@")) {
            score += 20;
        }

        if (link.length() > 100) {
            score += 10;
        }

        return score;
    }
}
