
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Keshav Narain Gainda
Student Number: 216891319
Course Section: B
*/

package Assignment1;
import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row = row;
		this.column = column;
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.	
		if( startRow > row -1 | destRow > row -1 | startCol > column - 1 | destCol > column - 1 | startCol < 0 | destCol < 0 | startRow < 0 | destRow < 0) {
			throw new IllegalArgumentException ( "invalid parameters !" );
		}
			
		else{
					if (destCol <= startCol & destRow <= startRow){
						path = goSouthWest(startRow, startCol, destRow, destCol , path) + path;
					} 
					else if(destCol >= startCol & destRow <= startRow) {
						path =  goSouthEast(startRow, startCol, destRow, destCol , path) + path;
					}
					
					else if( destCol >= startCol & destRow >= startRow) {
						path =  goNorthEast(startRow, startCol, destRow, destCol , path) + path;
					} 
					else {
						path =  goNorthWest(startRow, startCol, destRow, destCol , path) + path;
					}
		} 
		return path;	 
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		if (startCol == destCol & startRow == destRow) {
				path = " ";
		}
		else if(startCol != destCol) {
			    path = goSouthWest(startRow, startCol , destRow, destCol + 1, path) + path;
				
				} 
		else if ( startRow != destRow) {
			    path =  goSouthWest(startRow, startCol, destRow + 1, destCol, path) + path; 
			}
		return path;
		}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path){
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		if (startCol == destCol & startRow == destRow) {
				path = " "; 
		}
		else if(startCol != destCol) {
			    path = goSouthEast(startRow, startCol , destRow, destCol - 1, path) + path;
				} 
		
		else if ( startRow != destRow) {
			    path =  goSouthEast(startRow, startCol, destRow + 1, destCol, path) + path; 
			}
		return path;
		}

	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		if (startCol == destCol & startRow == destRow) {
				path = " ";
		}
		else if(startCol != destCol) {
			    path = goNorthEast(startRow, startCol , destRow, destCol - 1, path) + path;
				
				} 
		else if ( startRow != destRow) {
			    path =  goNorthEast(startRow, startCol, destRow - 1, destCol, path) + path; 
			}
		return path;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path){
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		if (startCol == destCol & startRow == destRow) {
				path = " ";
		}
		else if(startCol != destCol) {
			    path = goNorthWest(startRow, startCol , destRow, destCol + 1, path) + path;
				
				} 
		else if ( startRow != destRow) {
			    path =  goNorthWest(startRow, startCol, destRow - 1, destCol, path) + path; 
			}
		return path;
	}
	
	/**
	 * This method determines whether the current intersection has been previously visited or not.
	 * @param newPoint the point for the next intersection .
	 * @param visitedInts contains all the intersections visited previously.
	 * @return true if the intersection has been visited previously and false otherwise.
	 */
	public boolean pointInVisitedInts(String newPoint, ArrayList<String> visitedInts) {
		if (visitedInts.contains(newPoint)) {
			return true;
		}
		return false; 
	}
	/**
	 * This method returns random intersections for the car to move.
	 * @param currRow the row number of current intersection.
	 * @param currCol the column number of current intersection.
	 * @return a random point for the next intersection
	 */
	public List<Integer> getNewIntersection(int currRow, int currCol) {
		Random random = new Random();
		String[] nextMove = {"North", "South", "East", "West"};
		int choice = random.nextInt(nextMove.length);
		if (nextMove[choice] == "North") {
			currRow += 1;
		} 
		else if (nextMove[choice] == "South") {
			currRow -= 1;
		}
		else if (nextMove[choice] == "East") {
			currCol += 1;
		}
		else if (nextMove[choice] == "West") {
			currCol -= 1;
	    }
			
		List<Integer> nextPoint = new ArrayList<>();
		nextPoint.add(currRow);
		nextPoint.add(currCol);
		
		return nextPoint; 
	}
	
	/**
	 * This method checks if the car is currently at any of the intersections at the border of the city or not.
	 * @param currRow the row number of current intersection.
	 * @param currCol the column number of current intersection.
	 * @return true if the car is at any of the intersections at the border of the city and false otherwise.
	 */
	public boolean checkForBorder(int currRow, int currCol) {
		if (currRow == this.row - 1 || currRow == 0 || currCol == this.column - 1 || currCol == 0) {
			return true;
		}
		return false; 
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	public String findPath (int startRow, int startCol) { 
		String travelPath = "";
		int tempCol = startCol;															
		int tempRow = startRow;
		String pathOfCar = "(" + startRow + "," + startCol + ")";
		ArrayList<String> visitedInts = new ArrayList<String>();
		visitedInts.add(pathOfCar);
		 while (!checkForBorder(startRow, startCol)) {									//checking if the car is currently at border or not
			List<Integer> newPoint = getNewIntersection(startRow, startCol);
			String pointStr = "(" + newPoint.get(0) + "," + newPoint.get(1) + ")";
			if (pointInVisitedInts(pointStr, visitedInts)) {
					travelPath = findPath(tempRow, tempCol); 							//checking if the intersection has been visited previously or not
					break;
			}
			else {
				startRow = newPoint.get(0);
				startCol = newPoint.get(1);
				visitedInts.add(pointStr);
			}
			
		}
		
		if(travelPath.isEmpty()) {			
			for(String pointer : visitedInts) {											//for traversal in visitedInts ( arraylist )
				travelPath += pointer + " ";
			}
		}		
		return travelPath.trim(); 
	}
} // end of class
