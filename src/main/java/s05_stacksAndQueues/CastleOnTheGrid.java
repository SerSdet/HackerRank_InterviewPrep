package s05_stacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CastleOnTheGrid {
    public static void main(String[] args) {
        ArrayList<String> grid = new ArrayList<>();
        grid.add(".X.");
        grid.add(".X.");
        grid.add("...");

        int startX =0;
        int startY = 0;
        int goalX = 0;
        int goalY = 2;

        System.out.println(minSteps(grid, startX, startY, goalX, goalY));
    }

    /**
     * Algorithm required a BFS ( Breadth first search ) algorithm. This algorithm used to search node in tree or graph
     * data structure.
     * @param grid
     * @param startX
     * @param startY
     * @param goalX
     * @param goalY
     * @return Minimum number of steps required to reach goal x,y coordinates
     *
     * First, create new array with the same dimensions with grid to store step counts.
     * Then, create new deque to store nodes (for nodes new class called 'D' created) and start point added
     * with step count 1
     * After that start a while loop while deque has nodes in it,
     *      - Take one node D from the deque,
     *      - Check that if this is a goal x,y if so return the step count - 1 (bc we start from 1 )
     *      - Then check all four side of the node (with all four while loop), until grid ends or X found,
     *          if adjacent note not visited (means step count is 0) then change step count as current step plus one and
     *            add to the deque,
     *      -After all four side is checked then return to the start of the loop that we take one node from the queue
     */

    public static int minSteps(ArrayList<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();

        int[][]stepCount = new int[n][n];

        Deque<D> deque = new ArrayDeque<>();
        stepCount[startX][startY] = 1;
        deque.add(new D(startX,startY));

        int steps = -1;

        while (!deque.isEmpty()){
            D currentPoint = deque.remove();
            int currentStep = stepCount[currentPoint.x][currentPoint.y];

            if(currentPoint.x == goalX && currentPoint.y == goalY){
                steps = currentStep - 1;
                break;
            }

            int i = currentPoint.x - 1;
            while ( i >= 0 && grid.get(i).charAt(currentPoint.y) == '.'){
                if (stepCount[i][currentPoint.y] == 0){
                    stepCount[i][currentPoint.y] = currentStep + 1;
                    deque.add(new D(i, currentPoint.y));
                }
                i--;
            }

            i = currentPoint.x + 1;
            while (i < n && grid.get(i).charAt(currentPoint.y) == '.'){
                if(stepCount[i][currentPoint.y] == 0){
                    stepCount[i][currentPoint.y] = currentStep + 1;
                    deque.add(new D (i, currentPoint.y));
                }
                i ++;
            }

            i = currentPoint.y - 1;
            while (i >= 0 && grid.get(currentPoint.x).charAt(i) == '.'){
                if(stepCount[currentPoint.x][i] == 0){
                    stepCount[currentPoint.x][i] = currentStep + 1;
                    deque.add(new D(currentPoint.x, i));
                }
                i--;
            }

            i = currentPoint.y + 1;
            while (i < n  && grid.get(currentPoint.x).charAt(i) == '.'){
                if(stepCount[currentPoint.x][i] == 0){
                    stepCount[currentPoint.x][i] = currentStep + 1;
                    deque.add(new D(currentPoint.x, i));
                }
                i++;
            }

        }
        return steps;
    }

    /**
     * This class used for saving nodes as pairs, java pairs class can aslo be used for this purpose
     */
    private static class D{
        int x,y;
        public D(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() { return x;}

        public int getY() {return y;}

        public String toString(){
            return "( "+ this.x + "," + this.y + " )";
        }
    }
}
