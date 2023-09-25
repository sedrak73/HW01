import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.io.FileSaver;
import ij.gui.NewImage;
import ij.io.Opener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String stuFilePath = "filw.stu";
        int blackPixelValue = 0;

        
        int maxWidth = 800;  
        int maxHeight = 600; 
        ImagePlus imagePlus = NewImage.createByteImage("Course Image", maxWidth, maxHeight, 1, NewImage.FILL_WHITE);
        ImageProcessor ip = imagePlus.getProcessor();

        try (BufferedReader br = new BufferedReader(new FileReader(stuFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    String[] tokens = line.split(" ");

                    if (tokens.length == 2) {
                        int x = Integer.parseInt(tokens[0]);
                        int y = Integer.parseInt(tokens[1]);

                        
                        ip.putPixel(x, y, blackPixelValue);
                    }
                }
            }

            FileSaver fileSaver = new FileSaver(imagePlus);
            String outputFilePath = "Image.png";
            fileSaver.saveAsPng(outputFilePath);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
