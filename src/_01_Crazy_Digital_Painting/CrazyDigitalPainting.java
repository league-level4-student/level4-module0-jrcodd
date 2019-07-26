package _01_Crazy_Digital_Painting;

import java.awt.Color;

public class CrazyDigitalPainting {
	// 1. Create two final static integers for the width and height of the display.
	final static int displayHeight = 1200;
	final static int displayWidth = 800;
	// 2. Create a 2D array of Color objects. You will need to import
	// java.awt.Color. Initialize the size of the array using the
	// integers created in step 1.
	Color[][] colors = new Color[displayWidth][displayHeight];

	public CrazyDigitalPainting() {
		// 3. Open the crazy_digital_painting.png file and look at the image.

		// 4. Iterate through the 2D array and initialize each Color object
		// to a new color. The sample image was created using the following
		// pattern:
//		for (int i = 0; i < colors.length; i++) {
//			for (int j = 0; j < colors[i].length; j++) {
//				colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
//			}
//		}

		// 5. Come up with your own pattern to make a cool crazy image.
		for (int i = colors.length-1; i > -1; i--) {
			for (int j = colors[i].length-1; j > -1; j--) {
				colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
			}
		}
		// 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method
		// to show off your picture.
		ColorArrayDisplayer.displayColorsAsImage(colors);

	}

	public static void main(String[] args) {
		new CrazyDigitalPainting();
	}
}
