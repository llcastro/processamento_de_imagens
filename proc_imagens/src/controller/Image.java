package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Image {
    
    public void negativo(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //int rgb = imagem1.getRGB(i, j); // a cor inversa é dado por 255 menos o valor de cada canal 				
                //int r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
                //int g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
                //int b = 255 - (int) (rgb & 0x000000FF);

                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = 255 - cor.getRed();
                int g = 255 - cor.getGreen();
                int b = 255 - cor.getBlue();

                Color color = new Color(r, g, b);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public void escala_de_cinza(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = (int) (0.299 * cor.getRed());
                int g = (int) (0.587 * cor.getGreen());
                int b = (int) (0.114 * cor.getBlue());
                int y = r + g + b;

                Color color = new Color(y, y, y);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public void canal_vermelho(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = cor.getRed();

                Color color = new Color(r, r, r);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public void canal_verde(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int g = cor.getGreen();

                Color color = new Color(g, g, g);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public void canal_azul(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int b = cor.getBlue();

                Color color = new Color(b, b, b);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public void filtro_sepia(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();
                
                int rl = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                if (rl > 255) { rl = 255; }
                int gl = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                if (gl > 255) { gl = 255; }
                int bl = (int) (0.272 * r + 0.534 * g + 0.131 * b);
                if (bl > 255) { bl = 255; }

                Color color = new Color(rl, gl, bl);
                imagem_carregada.setRGB(i, j, color.getRGB());
            }
        }
    }
    
    public int aply_alfa(int c1, int c2, double alfa) {
        return (int) (c1 * (1-alfa) + c2 * alfa);
    }
    
    public void red_to_blue(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        float[] hsv = new float[3];
        Color.RGBtoHSB(255, 0, 0, hsv);
        float red = hsv[0];
        Color.RGBtoHSB(0, 0, 255, hsv);
        float blue = hsv[0];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();
                Color.RGBtoHSB(r, g, b, hsv);
                if(hsv[0] > 0.95 || hsv[0] < 0.05) {
                    int rgb = Color.HSBtoRGB(blue, hsv[1], hsv[2]);
                    Color color = new Color(rgb);
                    imagem_carregada.setRGB(i, j, color.getRGB());
                }
            }
        }
    }
    
    public void blue_to_red(BufferedImage imagem_carregada) {
        int width = imagem_carregada.getWidth();
        int height = imagem_carregada.getHeight();
        float[] hsv = new float[3];
        Color.RGBtoHSB(255, 0, 0, hsv);
        float red = hsv[0];
        Color.RGBtoHSB(0, 0, 255, hsv);
        float blue = hsv[0];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(imagem_carregada.getRGB(i, j));
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();
                Color.RGBtoHSB(r, g, b, hsv);
                if(hsv[0] < 0.20 || hsv[0] > 0.45) {
                    int rgb = Color.HSBtoRGB(0, 0, 0);
                    Color color = new Color(rgb);
                    imagem_carregada.setRGB(i, j, color.getRGB());
                }
            }
        }
    }
    
    
    
}
