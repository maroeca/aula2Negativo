import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maycow.carmo on 13/03/2017.
 */
public class aula02c {

    public int saturate(int valor)
    {
        if(valor > 255)
            return 255;
        if(valor < 0)
            return 0;

        return valor;
    }

    public BufferedImage negativo(BufferedImage img)
    {
        BufferedImage out = new BufferedImage(img.getWidth(),img.getHeight(),img.TYPE_INT_RGB);
        for(int y = 0; y < img.getHeight(); y++)
        {
            for(int x = 0; x < img.getWidth(); x++)
            {
                Color pixel = new Color(img.getRGB(x,y));
                int r = saturate(255 - pixel.getRed());
                int g = saturate(255 - pixel.getGreen());
                int b = saturate(255 - pixel.getBlue());
                Color newPixel = new Color(r, g, b);
                out.setRGB(x, y, newPixel.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        File PATH = new File("C:\\Users\\maycow.carmo\\img\\cor");
        BufferedImage metroid = ImageIO.read(new File(PATH, "metroid1.jpg"));
        BufferedImage metroidNeg = negativo(metroid);
        ImageIO.write(metroidNeg, "png", new File("metroidNegativo.png"));
    }

    public static void main(String[] args) throws IOException {
        aula02c aula = new aula02c();
        aula.run();
    }
}
