package edu.neumont.coordinate.gui;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;
import edu.neumont.coordinate.randomgenerator.*;
import edu.neumont.coordinate.randomgenerator.lcrg.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * https://sites.google.com/site/drjohnbmatthews/raster
 */
public class RandomPanel extends JPanel {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1000;

    private Coordinate[] coordinates;
    private Generator generator;

    public RandomPanel(Generator generator) {
        setPreferredSize(new Dimension(WIDTH / 2, HEIGHT / 2));

        int dots = 100000;
        this.generator = generator;

        coordinates = new Coordinate[dots];
        for (int i = 0; i < dots; i++) {
            coordinates[i] = generator.getNextCoordinate();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        final BufferedImage image;
        int[] iArray = { 0, 0, 0, 255};

        image = (BufferedImage) createImage(WIDTH / 2, HEIGHT / 2);
        WritableRaster raster = image.getRaster();
        for (Coordinate c : coordinates) {
            int x = c.getX() / 2;
            int y = c.getY() / 2;
            raster.setPixel(x, y, iArray);
            raster.setPixel((x + 1) % (WIDTH / 2), y, iArray);
            raster.setPixel(x, (y + 1) % (HEIGHT / 2), iArray);
            raster.setPixel((x + 1) % (WIDTH / 2), (y + 1) % (HEIGHT / 2), iArray);
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setDefaultLookAndFeelDecorated(true);
                f.setResizable(false);
                RandomPanel panel = new RandomPanel(new AnsiCLCG(5));
                f.add(panel, BorderLayout.CENTER);
                f.pack();
                f.setVisible(true);
            }
        });
    }
}
