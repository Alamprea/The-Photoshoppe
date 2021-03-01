package arrays2d;

// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ThePhotoShoppe extends Component {


    private String outputName;
    
  
    private Color[][] pixels;
 // I keep getting an error saying the image I chose is "out of bounds". I will try with a simpler image
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
       for (int i = 0; i < pixels.length; i++) {
    	   for (int j = 0; j < pixels[i].length; j++) {
    		   
    		   Color c = pixels [i] [j];
    		   
    		   int r = c.getRed() + amount;
    		   int g = c.getGreen() + amount;
    		   int b = c.getBlue() + amount;
    		   // this code is what I use for the method DeepFry, as making the image warmer is a simple matter of increasing the red and decreasing the blue
    		   if (r > 255)
    			   r = 255;
    		   if (b > 255)
    			   b = 255;
    		   if (g > 255)
    			   g = 255;
    		   
    		   pixels [i][j] = new Color(r, g, b);
    	   }
       }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        for (int i = 0; i < pixels.length; i++) {
     	   for (int j = 0, x1 = pixels[i].length - 1; j < pixels[i].length/2; j++, x1--) {
     		 Color y1 = pixels[i][j];
     		 Color y2 = pixels[i][x1];
     		 pixels[i][j] = y2;
     		 pixels[i][x1] = y1;
     		   
     		   
     		   }
     	   }     	   // I wasnt sure how to find the value of the pixel coordinates

        // your code here
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        for (int i = 0; i < pixels.length; i++) {
     	   for (int j = 0; j < pixels[j].length; j++) {
     		   
     		   Color c = pixels [i] [j];
     		   
     		   int r = 255 - c.getRed();
     		   int g = 255 - c.getGreen();
     		   int b = 255 - c.getBlue();
     		   // this code is what I use for the method DeepFry, as making the image warmer is a simple matter of increasing the red and decreasing the blue
     		   if (r > 255)
     			   r = 255;
     		   if (b > 255)
     			   b = 255;
     		   if (g > 255)
     			   g = 255;
     		   
     		   pixels [i][j] = new Color(r, g, b);
    }
        }
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        
        for (int i = 0; i < pixels.length; i++) {
     	   for (int j = 0; j < pixels[i].length; j++) {
     		   
     		   Color c = pixels [i] [j];
     		// I could determine which color out of RGB is used most, and then use that knowledge to choose how to simplify the color		   
     		   if (c.getRed() > c.getGreen() && c.getRed() > c.getBlue());{
     		   int r = 255;
     		   int g = 0;
     		   int b = 0;
     		   
     		   // this code must be repeated for each color, with specified instances of change

     		   pixels [i][j] = new Color(r, g, b);}
     		   
     		  if (c.getBlue() > c.getRed() && c.getBlue() > c.getGreen()){
        		   int r = 0;
        		   int g = 0;
        		   int b = 255;
        		   
        		   pixels [i][j] = new Color(r, g, b);}
     	   
     		  else if (c.getGreen() > c.getRed() && c.getGreen() > c.getBlue()){
       		   int r = 0;
       		   int g = 0;
       		   int b = 255;
       		   
       		   pixels [i][j] = new Color(r, g, b);}
     		  else if (c.getBlue() > c.getRed() && c.getBlue() > c.getGreen()){
       		   int r = 0;
       		   int g = 0;
       		   int b = 255;
       		   
       		   pixels [i][j] = new Color(r, g, b);}
     		  
     		  else if (c.getBlue() == c.getRed() || c.getBlue() == c.getRed() + 1 || c.getBlue() == c.getRed() - 1){
     			   int r = 255;
          		   int g = 0;
          		   int b = 255;
          		// Magenta can be simplified to 255, 0, 255   
          		   pixels [i][j] = new Color(r, g, b);}
     		  
     		  else if (c.getGreen() == c.getRed() || c.getGreen() == c.getRed() + 1 || c.getGreen() == c.getRed() - 1){
    			   int r = 255;
         		   int g = 255;
         		   int b = 0;
         		// Yellow can be simplified to 255, 255, 0
         		   pixels [i][j] = new Color(r, g, b);}
     	
     		  else if (c.getGreen() == c.getBlue() || c.getGreen() == c.getBlue() + 1 || c.getGreen() == c.getBlue() - 1){
 			   int r = 0;
      		   int g = 255;
      		   int b = 255;
      		// Cyan can be simplified to green and blue at their maximum values (0, 255, 255)
      		   pixels [i][j] = new Color(r, g, b);}
     		
     		  else if (c.getGreen() == c.getRed() && c.getGreen() == c.getBlue() && c.getGreen() >= 127){
 			   int r = 255;
      		   int g = 255;
      		   int b = 255;
      		//white is maximum of everything
      		   pixels [i][j] = new Color(r, g, b);}
     		  else if (c.getGreen() == c.getRed() && c.getGreen() == c.getBlue() && c.getGreen() < 127){
   			       int r = 0;
        		   int g = 0;
        		   int b = 0;
     		//black is 0/0/0
        	   pixels [i][j] = new Color(r, g, b);}
     		  else if (c.getGreen() == c.getRed() || c.getGreen() == c.getRed() + 1 || c.getGreen() == c.getRed() - 1 && c.getGreen() < 127){
        		   int r = 255;
             	   int g = 127;
             	   int b = 0;
             		// Yellow can be simplified to 255, 255, 0
               pixels [i][j] = new Color(r, g, b);}
         	
        	
  		  
     	   }
        }
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred ima

    public void blur() {
		outputName = "blurred_" + outputName;
		Color[][] pixelsII = new Color[h][w];
		for (int i = 0; i < pixels.length; i++) {
	     	   for (int j = 0; j < pixels[i].length; j++) {
	     	
	     	   pixelsII[i][j] = pixels[i][j];
	     	   
	     	   }}
		for (int i = 1; i < pixels.length - 1; i++) {
	     	   for (int j = 1; j < pixels[i].length - 1; j++) {
	     		 
	     	  int sumR = pixels[i + 1][j + 1].getRed() + pixels[i - 1][j + 1].getRed() + pixels[i][j + 1].getRed() + pixels[i + 1][j].getRed() + pixels[i - 1][j].getRed() + pixels[i][j].getRed() + pixels[i + 1][j - 1].getRed() + pixels[i - 1][j - 1].getRed() + pixels[i][j - 1].getRed();
	     	  int sumB = pixels[i + 1][j + 1].getBlue() + pixels[i - 1][j + 1].getBlue() + pixels[i][j + 1].getBlue() + pixels[i + 1][j].getBlue() + pixels[i - 1][j].getBlue() + pixels[i][j].getBlue() + pixels[i + 1][j - 1].getBlue() + pixels[i - 1][j - 1].getBlue() + pixels[i][j - 1].getBlue();
	     	  int sumG = pixels[i + 1][j + 1].getGreen() + pixels[i - 1][j + 1].getGreen() + pixels[i][j + 1].getGreen() + pixels[i + 1][j].getGreen() + pixels[i - 1][j].getGreen() + pixels[i][j].getGreen() + pixels[i + 1][j - 1].getGreen() + pixels[i - 1][j - 1].getGreen() + pixels[i][j - 1].getGreen();
	     	   
	     			 pixelsII [i][j] = new Color(sumR/9, sumG/9, sumB/9);
	     	   }}
		pixels = pixelsII;
		
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        Color[][] pixelsII = new Color[h][w];
		for (int i = 0; i < pixels.length; i++) {
	     	   for (int j = 0; j < pixels[i].length; j++) {
	     	
	     	   pixelsII[i][j] = pixels[i][j];
	     	   
	     	   }}
		for (int i = 1; i < pixels.length - 1; i++) {
	     	   for (int j = 1; j < pixels[i].length - 1; j++) {
	     		 
	     	  int sumR = pixels[i + 1][j + 1].getRed() + pixels[i - 1][j + 1].getRed() + pixels[i][j + 1].getRed() + pixels[i + 1][j].getRed() + pixels[i - 1][j].getRed() + pixels[i + 1][j - 1].getRed() + pixels[i - 1][j - 1].getRed() + pixels[i][j - 1].getRed();
	     	  int sumB = pixels[i + 1][j + 1].getBlue() + pixels[i - 1][j + 1].getBlue() + pixels[i][j + 1].getBlue() + pixels[i + 1][j].getBlue() + pixels[i - 1][j].getBlue() + pixels[i + 1][j - 1].getBlue() + pixels[i - 1][j - 1].getBlue() + pixels[i][j - 1].getBlue();
	     	  
	     	  int sumG = pixels[i + 1][j + 1].getGreen() + pixels[i - 1][j + 1].getGreen() + pixels[i][j + 1].getGreen() + pixels[i + 1][j].getGreen() + pixels[i - 1][j].getGreen() + pixels[i + 1][j - 1].getGreen() + pixels[i - 1][j - 1].getGreen() + pixels[i][j - 1].getGreen();
	     	  int regR = pixels[i][j].getRed() * 8;
	     	  int regB = pixels[i][j].getBlue() * 8;
	     	  int regG = pixels[i][j].getGreen() * 8;
	     	  int finR = regR - sumR; 
	     	  int finB = regB - sumB;
	     	  int finG = regG - sumG;
	     	   if (finR > 255)
    			   finR = 255;
	     	if (finR < 0)
   			   finR = 0;
    		   if (finB > 255)
    			   finB = 255;
    		if (finB < 0)
    			   finB = 0;
    		   if (finG > 255)
    			   finG = 255;
    		if (finG < 0)
    			   finG = 0;
	     			 pixelsII [i][j] = new Color(finR, finG, finB);
	     			 //
	     	   }}
		pixels = pixelsII;
        
    }
    
    public void DeepFry(int amount) {
        outputName = "fried_" + outputName;
        for (int i = 0; i < pixels.length; i++) {
     	   for (int j = 0; j < pixels[i].length; j++) {
     		   
     		   Color c = pixels [i] [j];
     		   
     		   int r = c.getRed() + amount;
     		   int b = c.getBlue() - amount;
     		   int g = c.getGreen();
     		   if (r > 255)
     			   r = 255;
     		   if (b > 255)
     			   b = 255;
     		   if (b < 0)
    			   b = 0;
     		   if (r < -255)
    			   r = -255;
     		   pixels [i][j] = new Color(r, g, b);
    }
        }}
    // *************** OFF LIMITS **************** //
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, DeepFry, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("DeepFry")) {
		    				System.out.println("enter an amount fry by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new ThePhotoShoppe();
	}

    public ThePhotoShoppe() {
		run();
    }
}