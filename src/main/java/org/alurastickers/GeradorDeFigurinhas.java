package org.alurastickers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorDeFigurinhas {

    public void criar(InputStream inputStream, String nomeArquivo) throws IOException {

        // Leitura da imagem

//        InputStream inputStream =
//                                  new FileInputStream("entrada/filme.jpg");
//        InputStream inputStream =
//                                    new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Criar nova imagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original pra nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0,0, null);

        // Configurar fonte

        var fonte = new Font("Impact", Font.BOLD, 120);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);


        // Escrever uma frase na nova imagem

        graphics.drawString("TOPZERA", 160, novaAltura - 100);

        // Escrever nova imagem em arquivo

        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }
}
