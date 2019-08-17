package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Cell startCell = Maze.cells[randGen.nextInt(Maze.cells.length)][randGen.nextInt(Maze.cells.length)];
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(startCell);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
currentCell.setBeenVisited(true);
		//B. check for unvisited neighbors using the cell
if(getUnvisitedNeighbors(currentCell).size()>0) {
		//C. if has unvisited neighbors,
		Cell newCell = getUnvisitedNeighbors(currentCell).get(randGen.nextInt());
			//C1. select one at random.
	uncheckedCells.push(newCell);
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells
          removeWalls(currentCell,newCell );
			//C4. make the new cell the current cell and mark it as visited
		currentCell = newCell;
			//C5. call the selectNextPath method with the current cell
		selectNextPath(currentCell);
}
			
		//D. if all neighbors are visited
		if(getUnvisitedNeighbors(currentCell).size()==0&& uncheckedCells.size()>0) {
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
		}
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
	if(c1.getX()>c2.getX()) {
		c1.setEastWall(false);
		c2.setWestWall(false);
	}
	else if(c1.getX()<c2.getX()) {
		c2.setEastWall(false);
		c1.setWestWall(false);
	
	}
	else if(c1.getY()<c2.getY()) {
		c2.setSouthWall(false);
		c1.setNorthWall(false);
	
	}
	else if(c1.getY()>c2.getY()) {
		c1.setSouthWall(false);
		c2.setNorthWall(false);
	
	}
	
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		for (int i = 0; i < Maze.cells.length; i++) {
			for (int j = i; j < Maze.cells.length-1; j++) {
				if(c.getX()+1 == Maze.cells[i][j].getX() && c.getY() == Maze.cells[i][j].getY()) {
					neighbors.add(Maze.cells[i][j]);
				}if(c.getX()+1 == Maze.cells[i][j].getX() && c.getY()+1 == Maze.cells[i][j].getY()) {
					neighbors.add(Maze.cells[i][j]);
				}if(c.getX() == Maze.cells[i][j].getX() && c.getY()+1 == Maze.cells[i][j].getY()) {
					neighbors.add(Maze.cells[i][j]);
				}if(c.getX()-1 == Maze.cells[i][j].getX() && c.getY() == Maze.cells[i][j].getY()) {
					neighbors.add(Maze.cells[i][j]);
				}if(c.getX() == Maze.cells[i][j].getX() && c.getY()-1 == Maze.cells[i][j].getY()) {
					neighbors.add(Maze.cells[i][j]);
				}
			}
		}
		
		
		
		
		
		return neighbors;
	}
}
