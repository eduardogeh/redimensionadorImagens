import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Redimensionar {
    public static void main(String[] args) throws IOException {
        if(args.length < 2 || args.length > 3) {
            System.out.println("Modo de Uso: java Redimensionar <CaminhoImagem> <largura> <altura>");
            System.exit(1);
        }
        redimensionarImagem(String.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2]));
        System.out.println("Imagem redimensionada com sucesso!");
        }

    public static void redimensionarImagem(String caminhoImagem, Integer novaLargura, Integer novaAltura) throws IOException {
        try {
            File imagem = new File(caminhoImagem);
            BufferedImage bufferedImage = ImageIO.read(imagem);
            BufferedImage scaledImage = new BufferedImage(novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.drawImage(bufferedImage, 0, 0, novaLargura, novaAltura, null);
            graphics2D.dispose();
            ImageIO.write(scaledImage, "jpeg", imagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}