import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class GeneralPathRoundedRectangle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Create a GeneralPath
        GeneralPath path = new GeneralPath();

        int cornerRadius = 30; // Adjust corner radius as needed

        // Move to the starting point
        path.moveTo(cornerRadius, 0);

        // Draw the top line
        path.lineTo(width - cornerRadius, 0);

        // Draw the top-right corner
        path.quadTo(width, 0, width, cornerRadius);

        // Draw the right line
        path.lineTo(width, height - cornerRadius);

        // Draw the bottom-right corner
        path.quadTo(width, height, width - cornerRadius, height);

        // Draw the bottom line
        path.lineTo(cornerRadius, height);

        // Draw the bottom-left corner
        path.quadTo(0, height, 0, height - cornerRadius);

        // Draw the left line
        path.lineTo(0, cornerRadius);

        // Draw the top-left corner
        path.quadTo(0, 0, cornerRadius, 0);

        // Close the path
        path.closePath();

        // Set the color and draw the path
        g2d.setColor(Color.PINK);
        g2d.fill(path);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GeneralPathRoundedRectangle());
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}
