

package sudoku_Final;


public class Cell {
    int x;
    int y;
    
    public Cell() {
        x = 0;
        y = 0;
    }
    
    public Cell(int i, int j) {
        x = i;
        y = j;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}