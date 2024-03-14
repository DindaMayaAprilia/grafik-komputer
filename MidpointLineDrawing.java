import java.awt.*;
import javax.swing.*;

public class MidpointLineDrawing extends JPanel {
    private int x1, y1, x2, y2;

    public MidpointLineDrawing(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hitung dx, dy, dan p0 awal
        int dx = x2 - x1;
        int dy = y2 - y1;
        int p = 2 * dy - dx;
        int x = x1, y = y1;

        // Gambar titik awal
        drawPixel(g, x, y);

        // Iterasi melalui setiap titik
        while (x < x2) {
            x++;
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                y--;
                p = p + 2 * dy - 2 * dx;
            }
            // Gambar titik saat ini
            drawPixel(g, x, y);
        }
    }

    private void drawPixel(Graphics g, int x, int y) {
        // Menentukan ukuran titik
        int pointSize = 3;
        g.setColor(Color.BLACK);
        // Menggambar titik
        g.fillRect(x, y, pointSize, pointSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Midpoint Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        int x1 = 50, y1 = 300;
        int x2 = 350, y2 = 50;

        MidpointLineDrawing panel = new MidpointLineDrawing(x1, y1, x2, y2);
        frame.add(panel);

        frame.setVisible(true);
    }
}
