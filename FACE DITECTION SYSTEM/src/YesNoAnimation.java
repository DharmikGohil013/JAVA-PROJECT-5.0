import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingAnimationDemo {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showLoadingPage());
    }
    
    // Method to display the loading page
    public static void showLoadingPage() {
        JFrame loadingFrame = new JFrame("Loading");
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setSize(300, 200);
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setLayout(new BorderLayout());
        
        JLabel loadingLabel = new JLabel("Loading", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Serif", Font.BOLD, 24));
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

    // Method to display the next page
    public static void showNextPage() {
        JFrame nextFrame = new JFrame("Next Page");
        nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextFrame.setSize(300, 200);
        nextFrame.setLocationRelativeTo(null);
        nextFrame.setLayout(new BorderLayout());

        JLabel nextLabel = new JLabel("Welcome to the next page!", SwingConstants.CENTER);
        nextLabel.setFont(new Font("Serif", Font.BOLD, 24));
        nextFrame.add(nextLabel, BorderLayout.CENTER);

        // Show the next page
        nextFrame.setVisible(true);
    }
}
