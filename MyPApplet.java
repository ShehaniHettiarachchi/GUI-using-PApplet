package selfStudy;

import processing.core.*;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; 

public class MyPApplet extends PApplet{
	
	private String URL;
	
	/*loads an image into a variable of type PImage .
	 4 types of images (.gif, .jpg, .tgo, .png)images may be loaded. To load correctly*/
	private PImage backgroundImg;
	
	
	
	//Add setup code for MyPApplet. setup method only executed once
	public void setup() {
		//background image
		URL = "https://cdn.pixabay.com/photo/2016/09/07/11/37/sunset-1651426__340.jpg";
		
		//load image from 0 web server
		backgroundImg = loadImage(URL, "jpg");
	}
	
	//Add draw code for MyPApplet.draw() method gets executed repeatedly
	public void draw() {
		
		//calculate color code for sun
		int[] color = sunColorSec(second());
		
		//resize the original image by dynamically--->backgroundImg.resize(0,height);
		backgroundImg.resize(2000,1000);
		
		image(backgroundImg,0,0);
			
	
		//fill the second sun with color
		fill(color[0], color[1], color[2]);
			
		/*draw a second sun on the background
		first width & height for position and other one for shape*/
		ellipse(width/6, height/4, width/8, height/5);
							
	}
	
	public int[] sunColorSec(float seconds) {
		int[] rgb = new int[3];
		
		/*Scale the brightness of the yellow based on the seconds.
		 * 30 seconds is black.    0 seconds is bright yellow*/
		
		float diffFrom30 = Math.abs(30-seconds);//math.abs calculate the absolute value of a number
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		return rgb;
	}

	
}	
	


