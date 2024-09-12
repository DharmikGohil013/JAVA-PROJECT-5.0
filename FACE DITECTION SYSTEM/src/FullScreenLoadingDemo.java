import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FullScreenLoadingDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showLoadingPage());
    }

    // Method to display the loading page in full-screen
    public static void showLoadingPage() {
        JFrame loadingFrame = new JFrame("Loading");
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen mode
        loadingFrame.setUndecorated(true); // Remove window borders
        loadingFrame.setLayout(new BorderLayout());

        JLabel loadingLabel = new JLabel("Loading", SwingConstants.CENTER);
        
        loadingLabel.setFont(new Font("Serif", Font.BOLD, 100)); // Larger font for visibility
        loadingLabel.setForeground(Color.WHITE); // White text for contrast
        loadingLabel.setBackground(Color.BLACK); // Black background for contrast
        loadingLabel.setOpaque(true); // Ensure background color is visible
        loadingFrame.add(loadingLabel, BorderLayout.CENTER);

        // Show the loading page
        loadingFrame.setVisible(true);

        // Timer to update the loading label
        Timer timer = new Timer(1000, new ActionListener() {
            private int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (count % 4) {
                    case 0:
                        loadingLabel.setText("Loading.");
                        break;
                    case 1:
                        loadingLabel.setText("Loading..");
                        break;
                    case 2:
                        loadingLabel.setText("Loading...");
                        break;
                    case 3:
                        loadingLabel.setText("Loading");
                        break;
                }
                count++;
            }
        });
        timer.start();

        // Stop the timer and transition to the next page after 5 seconds
        new Timer(5000, e -> {
            timer.stop(); // Stop the loading animation
            loadingFrame.dispose(); // Close the loading frame
            showNextPage(); // Open the next page
        }).start();
    }

    // Method to display the next page in full-screen
    public static void showNextPage() {
        JFrame nextFrame = new JFrame("Next Page");
        nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen mode
        nextFrame.setUndecorated(true); // Remove window borders
        nextFrame.setLayout(new BorderLayout());
        JLabel label = new JLabel("GDCS");
        label.setBounds(50, 50, 200, 100); // x, y, width, height
        label.setOpaque(true); // To ensure background color is visible
        label.setBackground(Color.LIGHT_GRAY); 

        JLabel nextLabel = new JLabel("Welcome to the next page!", SwingConstants.CENTER);
        nextLabel.setFont(new Font("Serif", Font.BOLD, 48)); // Larger font for visibility
        nextLabel.setForeground(Color.WHITE); // White text for contrast
        nextLabel.setBackground(Color.BLACK); // Black background for contrast
        nextLabel.setOpaque(true); // Ensure background color is visible
        nextFrame.add(nextLabel, BorderLayout.CENTER);

        // Show the next page
        nextFrame.setVisible(true);
    }
}
