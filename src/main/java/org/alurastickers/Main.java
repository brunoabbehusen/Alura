package org.alurastickers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Fazer uma conexão HTTP e buscar os tops 10 filmes

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Extrair só os dados que interessam (título, poster e classificação)

        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados

        float star;

        for (Map<String, String> filme : listaDeFilmes) {

            System.out.println("\u001b[1m Título: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m Poster: \u001b[m" + filme.get("image"));


            star = Float.parseFloat(filme.get("imDbRating"));

            if(star <= 1.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[31m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐");
            }
            else if(star <= 2.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[31m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐");
            }
            else if(star <= 3.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[31m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐");
            }
            else if(star <= 4.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[31m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐");
            }
            else if(star <= 5.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[33m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐");
            }
            else if(star <= 6.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[33m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐⭐");
            }
            else if(star <= 7.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[33m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐⭐⭐");
            }
            else if (star <= 8.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[32m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐");
            }
            else if (star <= 9.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[32m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐");
            }
            else if (star > 9.6){
                System.out.println("\u001b[1m Classificação: \u001b[m \u001b[32m" + filme.get("imDbRating") + "\u001b[m");
                System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
            }
            System.out.println();
        }

    }
}