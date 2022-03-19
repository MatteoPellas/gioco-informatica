package com.example.monkeybross;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CaricaImmagini {
    BufferedImage image;

    public BufferedImage caricaImmagine(String src) {
        try {
            image = ImageIO.read(getClass().getResource(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}