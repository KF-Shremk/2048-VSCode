import java.util.*;
import hsa.Console;
import java.awt.*;

public class Prototype2048 {
     static Console c;
     
     public static void main (String []args) {
          c = new Console ();
          int [][] grid = new int [4][4];
          
          newValue(grid);
          printArray(grid);
          while (true) {
               c.print("\n\nenter a move (wasd):");
               char move = c.getChar();
               
               if (move == 'w') {
                    up (grid);
               }
               else if (move == 'a') {
                    left (grid);
               }
               else if (move == 's') {
                    down (grid);
               }
               else if (move == 'd') {
                    right (grid);
               }
               
               newValue(grid);
               c.clear();
               printArray(grid);
          }
          
     } //end of main method
     
     public static void newValue (int [][] grid) {
          int x;
          int y;
          while (true) {
               x = (int)(Math.random()*4);
               y = (int)(Math.random()*4);
               if (grid [x][y] == 0) {
                    break;
               }
          }
          grid [x][y] = 2;
     } //end of newValue method
     
     public static void right (int [][] grid) { //----------------------------------------RIGHT
          //move all to the right
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 3; y >= 0; y--) { //each spot in the row
                    if (grid [x][y] == 0) {
                         for (int z = y-1; z >= 0; z--) {
                              if (grid[x][z] != 0) {
                                   grid [x][y] = grid [x][z];
                                   grid [x][z] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
          //combine like terms
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 3; y > 0; y--) { //each spot in the row (right to left)
                    if (grid [x][y] == grid[x][y-1] && grid[x][y] != 0) {
                         grid [x][y] *= 2;
                         grid [x][y-1] = 0;
                         y--;
                    }
               }
          }
          //move all to the right
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 3; y >= 0; y--) { //each spot in the row
                    if (grid [x][y] == 0) {
                         for (int z = y-1; z >= 0; z--) {
                              if (grid[x][z] != 0) {
                                   grid [x][y] = grid [x][z];
                                   grid [x][z] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
     } //end of right method
     
     public static void left (int [][] grid) { //----------------------------------------LEFT
          //move all to the left
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 0; y < 4; y++) { //each spot in the row
                    if (grid [x][y] == 0) {
                         for (int z = y+1; z < 4; z++) {
                              if (grid[x][z] != 0) {
                                   grid [x][y] = grid [x][z];
                                   grid [x][z] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
          //combine like terms
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 0; y < 3; y++) { //each spot in the row (left to right)
                    if (grid [x][y] == grid[x][y+1] && grid[x][y] != 0) {
                         grid [x][y] *= 2;
                         grid [x][y+1] = 0;
                         y++;
                    }
               }
          }
          //move all to the left
          for (int x = 0; x < 4; x++) { //each row
               for (int y = 0; y < 4; y++) { //each spot in the row
                    if (grid [x][y] == 0) {
                         for (int z = y+1; z < 3; z++) {
                              if (grid[x][z] != 0) {
                                   grid [x][y] = grid [x][z];
                                   grid [x][z] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
     } //end of left method
     
     public static void up (int [][] grid) { //----------------------------------------UP
          //move all to the top
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 0; x < 4; x++) { //each spot in the column
                    if (grid [x][y] == 0) {
                         for (int z = x+1; z < 4; z++) {
                              if (grid[z][y] != 0) {
                                   grid [x][y] = grid [z][y];
                                   grid [z][y] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
          //combine like terms
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 0; x < 3; x++) { //each spot in the column (top to bottom)
                    if (grid [x][y] == grid[x+1][y] && grid[x][y] != 0) {
                         grid [x][y] *= 2;
                         grid [x+1][y] = 0;
                         x++;
                    }
               }
          }
          //move all to the top
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 0; x < 4; x++) { //each spot in the column
                    if (grid [x][y] == 0) {
                         for (int z = x+1; z < 4; z++) {
                              if (grid[z][y] != 0) {
                                   grid [x][y] = grid [z][y];
                                   grid [z][y] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
     } //end of up method
     
     public static void down (int [][] grid) { //----------------------------------------DOWN
          //move all to the bottom
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 3; x >= 0; x--) { //each spot in the column
                    if (grid [x][y] == 0) {
                         for (int z = x-1; z >= 0; z--) {
                              if (grid[z][y] != 0) {
                                   grid [x][y] = grid [z][y];
                                   grid [z][y] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
          //combine like terms
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 3; x > 0; x--) { //each spot in the column (bottom to top)
                    if (grid [x][y] == grid[x-1][y] && grid[x][y] != 0) {
                         grid [x][y] *= 2;
                         grid [x-1][y] = 0;
                         x--;
                    }
               }
          }
          //move all to the bottom
          for (int y = 0; y < 4; y++) { //each column
               for (int x = 3; x >= 0; x--) { //each spot in the column
                    if (grid [x][y] == 0) {
                         for (int z = x-1; z >= 0; z--) {
                              if (grid[z][y] != 0) {
                                   grid [x][y] = grid [z][y];
                                   grid [z][y] = 0;
                                   break;
                              }
                         }
                    }
               }
          }
     } //end of down method
     
     public static void printArray (int [][] array) {
          for (int x = 0; x < array.length; x++) {
               for (int y = 0; y < array[x].length; y++) {
//                    System.out.printf("%-4d",array [x][y]);
                    if (array [x][y] != 0)
                         c.print(array[x][y],4);
                    else
                         c.print("   .");
               }
//               System.out.println();
               c.println();
          }
     } //end of printArray method
}