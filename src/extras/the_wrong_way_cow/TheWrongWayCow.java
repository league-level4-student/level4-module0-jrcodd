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

	public static int[] findWrongWayCow(final char[][] field) {
		int south = 0;
		int north = 0;
		int east = 0;
		int west = 0;
		int[] coords = new int[] { 0, 0 };
		HashMap<String, int[]> hm = new HashMap<String, int[]>();
		boolean canbreak = true;
		for (int i = 0; i < field.length && canbreak; i++) {

			for (int j = 0; j < field[i].length; j++) {

				if (field[i][j] == 'c') {

					if (i + 2 < field.length) {

						if (field[i + 1][j] == 'o') {
							if (field[i + 2][j] == 'w') {

								hm.put("north", new int[] { j, i });
								north += 1;

							}
						}
					}
					if (i - 2 >= 0) {
						if (field[i - 1][j] == 'o') {
							if (field[i - 2][j] == 'w') {

								south += 1;
								hm.put("south", new int[] { j, i });

							}

						}
					}
					if (j + 2 < field[i].length) {
						if (field[i][j + 1] == 'o') {
							if (field[i][j + 2] == 'w') {

								west += 1;
								hm.put("west", new int[] { j, i });

							}
						}
					}

					if (j - 2 >= 0) {
						if (field[i][j - 1] == 'o') {
							if (field[i][j - 2] == 'w') {

								east += 1;
								hm.put("east", new int[] { j, i });

							}
						}
					}
				}
			}
			if (north + south + east + west >= 3) {
				if (hm.size() > 1) {
					if (north == 1) {
						coords = hm.get("north");
					} else if (south == 1) {
						coords = hm.get("south");

					} else if (east == 1) {
						coords = hm.get("east");

					} else if (west == 1) {
						coords = hm.get("west");

					}

					canbreak = false;
					break;
				}
			}

		}
		System.out.println(coords[0]);
		System.out.println(coords[1]);
		return coords;

	}
}