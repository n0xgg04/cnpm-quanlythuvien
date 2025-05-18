package com.example.main.utils;

import javax.swing.ImageIcon;
import java.awt.Image;

public class BarcodeUtils {
    public static ImageIcon createBarcodeIcon(String barcodeImageUrl) {
        try {
            if (barcodeImageUrl != null && !barcodeImageUrl.isEmpty()) {
                java.net.URL url = new java.net.URL(barcodeImageUrl);
                java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(url);
                if (img != null) {
                    return new ImageIcon(img.getScaledInstance(120, 50, Image.SCALE_SMOOTH));
                }
            }
        } catch (Exception e) {
        }
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(120, 50,
                java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2 = img.createGraphics();
        g2.setColor(java.awt.Color.LIGHT_GRAY);
        g2.fillRect(0, 0, 120, 50);
        g2.setColor(java.awt.Color.BLACK);
        g2.drawString("Barcode", 30, 25);
        g2.dispose();
        return new ImageIcon(img);
    }

}
