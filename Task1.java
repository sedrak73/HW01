import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> courseData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("file.crs"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    String courseCode = parts[0];
                    int capacity = Integer.parseInt(parts[1]);
                    courseData.put(courseCode, capacity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImagePlus imagePlus = NewImage.createByteImage("Course Image", 800, 600, 1, NewImage.FILL_WHITE);

        ImageProcessor ip = imagePlus.getProcessor();

        
        for (String courseCode : courseData.keySet()) {
            int capacity = courseData.get(courseCode);
            int x = 0;
            int y = 0;

            ip.putPixel(x, y, 0);
            
            x++;
            y++;
        }

        imagePlus.show();

        IJ.save(imagePlus, "output.png");
    }
}
