//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.HashMap;

public class TheWrongWayCow {
	enum Direction {
		NORTH, SOUTH, EAST, WEST
	}

	static int south = 0;
	static int north = 0;
	static int east = 0;
	static int west = 0;
	static Direction majority;
	static int[] coords = new int[] { 0, 0 };
	static HashMap<String, int[]> hm = new HashMap<String, int[]>();
	static boolean canbreak = true;

	public static int[] findWrongWayCow(final char[][] field) {

		for (int i = 0; i < field.length && canbreak; i++) {

			for (int j = 0; j < field[i].length; j++) {

				if (field[i][j] == 'c') {

					if (i + 1 < field.length - 1) {

						if (field[i + 1][j] == 'o') {
							if (field[i + 2][j] == 'w') {

								hm.put("north", new int[] { i, j });
								north += 1;

							}
						}
					}
					if (i - 1 > 0) {
						if (field[i - 1][j] == 'o') {
							if (field[i - 2][j] == 'w') {

								south += 1;

							}

						}
					}
					if (j + 1 < field[i].length) {
						if (field[i][j + 1] == 'o') {
							if (field[i][j + 2] == 'w') {

								west += 1;
							}
						}
					}

					if (j - 1 > 0) {
						if (field[i][j - 1] == 'o') {
							if (field[i][j - 2] == 'w') {

								east += 1;

							}
						}
					}

					if (north + south + east + west >= 3) {
						if (hm.size() > 1) {
							coords = new int[] { i, j };
							canbreak = false;
							break;
						}
					}
				}
			}
		}
		return coords;

	}
}