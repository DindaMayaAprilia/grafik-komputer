import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class AnimasiHatiBerdetak extends JPanel {

    private static final int LEBAR = 600;
    private static final int TINGGI = 400;
    private static final int LEBAR_HATI = 50;
    private static final int TINGGI_HATI = 50;
    private static final int PANJANG_GARIS = 400;
    private static final int KECEPATAN_HATI = 3;

    private int posisiGarisX = 100;
    private int posisiGarisY = TINGGI / 2;
    private int posisiHatiX = 0;
    private int posisiHatiY = 0;
    private int arah = 1;

    public AnimasiHatiBerdetak() {
        Timer timer = new Timer(20, e -> {
            posisiGarisX += KECEPATAN_HATI * arah;
            if (posisiGarisX >= LEBAR - PANJANG_GARIS || posisiGarisX <= 0) {
                arah *= -1;
            }
            posisiHatiX = posisiGarisX + PANJANG_GARIS / 2 - LEBAR_HATI / 2;
            posisiHatiY = posisiGarisY - TINGGI_HATI / 2;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Gambar garis
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, posisiGarisY, LEBAR, posisiGarisY);

        // Gambar hati
        GeneralPath hati = new GeneralPath();
        hati.moveTo(posisiHatiX + LEBAR_HATI / 2, posisiHatiY + TINGGI_HATI / 4);
        hati.curveTo(posisiHatiX + LEBAR_HATI, posisiHatiY, posisiHatiX + LEBAR_HATI, posisiHatiY + TINGGI_HATI / 2, posisiHatiX + LEBAR_HATI / 2, posisiHatiY + TINGGI_HATI);
        hati.curveTo(posisiHatiX, posisiHatiY + TINGGI_HATI / 2, posisiHatiX, posisiHatiY, posisiHatiX + LEBAR_HATI / 2, posisiHatiY + TINGGI_HATI / 4);
        hati.closePath();

        g2d.setColor(Color.pink);
        g2d.fill(hati);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(LEBAR, TINGGI);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animasi Hati Berdetak");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AnimasiHatiBerdetak());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

