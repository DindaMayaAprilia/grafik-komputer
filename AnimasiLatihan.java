import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AnimasiLatihan extends JPanel {

    private static final int LEBAR = 400;
    private static final int TINGGI = 400;
    private static final int JARI_JARI_TITIK = 5;
    private static final int TOTAL_FRAME = 100;
    private static final int JARAK_TITIK = 3;

    private int hitungFrame = 0;
    private double x = 200; // koordinat awal x
    private double y = 200; // koordinat awal y

    public AnimasiLatihan() {
        Timer timer = new Timer(20, e -> {
            hitungFrame++;
            if (hitungFrame <= TOTAL_FRAME) {
                gerakTitik();
                repaint();
            }
        });
        timer.start();
    }

    private void gerakTitik() {
        double sudut = Math.toRadians(hitungFrame * 360.0 / TOTAL_FRAME);
        x = 200 + JARAK_TITIK * Math.cos(sudut);
        y = 200 + JARAK_TITIK * Math.sin(sudut);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Gambar titik
        Ellipse2D.Double titik = new Ellipse2D.Double(x - JARI_JARI_TITIK, y - JARI_JARI_TITIK, 2 * JARI_JARI_TITIK, 2 * JARI_JARI_TITIK);
        g2d.setColor(Color.black);
        g2d.fill(titik);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LEBAR, TINGGI);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animasi Latihan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AnimasiLatihan());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

