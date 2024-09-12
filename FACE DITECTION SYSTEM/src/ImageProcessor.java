// import javax.swing.*;
// import java.awt.*;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;
// import org.opencv.core.*;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.Imgproc;
// import org.opencv.core.Mat;
// import org.opencv.core.CvType;
// import org.opencv.core.MatOfByte;
// import org.opencv.core.MatOfFloat;

// public class ImageProcessor extends JFrame {
//     static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

//     private JLabel imageLabel;

//     public ImageProcessor() {
//         setTitle("OpenCV Image Processor");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         setLayout(new BorderLayout());

//         imageLabel = new JLabel();
//         add(new JScrollPane(imageLabel), BorderLayout.CENTER);

//         JButton loadButton = new JButton("Load Image");
//         loadButton.addActionListener(e -> loadImage());
//         add(loadButton, BorderLayout.SOUTH);
//     }

//     private void loadImage() {
//         JFileChooser fileChooser = new JFileChooser();
//         int returnValue = fileChooser.showOpenDialog(this);
//         if (returnValue == JFileChooser.APPROVE_OPTION) {
//             File file = fileChooser.getSelectedFile();
//             processImage(file.getAbsolutePath());
//         }
//     }

//     private void processImage(String filePath) {
//         Mat image = Imgcodecs.imread(filePath);
//         if (image.empty()) {
//             JOptionPane.showMessageDialog(this, "Failed to load image", "Error", JOptionPane.ERROR_MESSAGE);
//             return;
//         }

//         Mat grayImage = new Mat();
//         Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

//         BufferedImage bufferedImage = matToBufferedImage(grayImage);
//         ImageIcon icon = new ImageIcon(bufferedImage);
//         imageLabel.setIcon(icon);
//         revalidate();
//         repaint();
//     }

//     private BufferedImage matToBufferedImage(Mat mat) {
//         int type = BufferedImage.TYPE_BYTE_GRAY;
//         if (mat.channels() > 1) {
//             type = BufferedImage.TYPE_3BYTE_BGR;
//         }
//         BufferedImage bufferedImage = new BufferedImage(mat.cols(), mat.rows(), type);
//         byte[] data = new byte[mat.cols() * mat.rows() * (int)mat.elemSize()];
//         mat.get(0, 0, data);
//         bufferedImage.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);
//         return bufferedImage;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new ImageProcessor().setVisible(true));
//     }
// }
