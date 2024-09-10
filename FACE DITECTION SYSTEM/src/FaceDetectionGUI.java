import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class FaceDetectionGUI extends JFrame {

    private JLabel imageLabel;

    public FaceDetectionGUI() {
        // Set up the GUI window
        setTitle("Face Detection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Face Detection");
        add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(e -> startFaceDetection());

        setVisible(true);
    }

    private void startFaceDetection() {
        // Load OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Set up face detector
        CascadeClassifier faceDetector = new CascadeClassifier("resources/haarcascade_frontalface_alt.xml");

        // Open the default camera
        VideoCapture camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera not detected");
            return;
        }

        Mat frame = new Mat();
        MatOfRect faceDetections = new MatOfRect();

        while (true) {
            if (camera.read(frame)) {
                // Detect faces
                faceDetector.detectMultiScale(frame, faceDetections);

                // Draw rectangles around detected faces
                for (Rect rect : faceDetections.toArray()) {
                    Imgproc.rectangle(frame, new org.opencv.core.Point(rect.x, rect.y),
                            new org.opencv.core.Point(rect.x + rect.width, rect.y + rect.height),
                            new Scalar(0, 255, 0), 3);
                }

                // Convert Mat to BufferedImage for displaying in the GUI
                BufferedImage image = matToBufferedImage(frame);
                imageLabel.setIcon(new ImageIcon(image));
                imageLabel.repaint();
            }

            try {
                Thread.sleep(30);  // Delay for smooth video stream
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Convert OpenCV Mat to BufferedImage
    private BufferedImage matToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR; // Color image
        } else if (mat.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY; // Grayscale image
        } else {
            throw new IllegalArgumentException("Unsupported number of channels: " + mat.channels());
        }

        // Create an empty BufferedImage
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);

        // Prepare an array to hold the pixel data
        byte[] data = new byte[mat.rows() * mat.cols() * (int) mat.elemSize()];
        mat.get(0, 0, data); // Get the pixel data from the Mat

        // Copy the data into the BufferedImage
        if (type == BufferedImage.TYPE_3BYTE_BGR || type == BufferedImage.TYPE_BYTE_GRAY) {
            byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
            System.arraycopy(data, 0, targetPixels, 0, data.length);
        }

        return image;
    }

    public static void main(String[] args) {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("OpenCV library loaded successfully.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error loading OpenCV library: " + e.getMessage());
        }
        
        // Initialize and show the GUI
        SwingUtilities.invokeLater(FaceDetectionGUI::new);
        
    }
}
