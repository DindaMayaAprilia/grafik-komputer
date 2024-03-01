import javax.swing.*;
import java.awt.*;

public class HurufD extends JPanel {

    private static final int LEBAR = 400;
    private static final int TINGGI = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Mengatur warna dan ketebalan garis
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));

        // Menggambar huruf D
        int x1 = 50, y1 = 50; // Posisi awal
        int x2 = 100, y2 = 60; // Titik atas
        int x3 = 125, y3 = 95; // Titik kanan atas
        int x4 = 100, y4 = 135; // Titik kanan bawah
        int x5 = 50, y5 = 150; // Titik kiri bawah

        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, x3, y3);
        g2d.drawLine(x3, y3, x4, y4);
        g2d.drawLine(x4, y4, x5, y5);
        g2d.drawLine(x5, y5, x1, y1);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LEBAR, TINGGI);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Huruf D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HurufD());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
