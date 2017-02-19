package sudoku_Final;

import java.util.ArrayList;


public class Board {
    private int[][] cells;
    private int size;
    
    public Board(int size) {
        cells = new int[size][size];
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setCell(int x, int y, int cell) {
        cells[x][y] = cell;
    }
    
    public int getCell(int x, int y) {
        return cells[x][y];
    }
    
    public ArrayList<Cell> getEmptyCells() {
        ArrayList<Cell> emptyCells = new ArrayList<>();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (cells[i][j] == 0)
                    emptyCells.add(new Cell(i,j));
        return emptyCells;
    }
    
    public boolean isCellEmpty(int x, int y) {
        Cell cell = new Cell();
        cell.setX(x);
        cell.setX(y);
        return(getEmptyCells().contains(cell));
    }
    
    
    public boolean isPossibleInX(int x, int y, int cell) {
        for (int i = 0; i < size; i++)
            if (!isCellEmpty(x, i) && cells[x][i] == cell)
                return false;
        return true;
    }
    
    
    public boolean isPossibleInY(int x, int y, int cell) {
        for (int i = 0; i < size; i++)
            if (!isCellEmpty(i, y) && cells[i][y] == cell)
                return false;
        return true;
    }
    
    public boolean isInBlock(int x, int y, int blockStartX, int blockStartY, int blockSize) {
        if (x >= blockStartX || x < blockStartX + blockSize)
            if (y >= blockStartY || y < blockStartY + blockSize)
                return true;
        return false;
    }
    
    public boolean isPossibleInBlock(int x, int y, int blockStartX, int blockStartY, int blockSize, int number) {
        if (isInBlock(x, y, blockStartX, blockStartY, blockSize))        
            for (int i = blockStartX; i < blockStartX + blockSize; i++)
                for (int j = blockStartY; j < blockStartY + blockSize; j++)
                    if (!isCellEmpty(i, j) && cells[i][j] == number)
                        return false;
        return true;
    }
    
    public Cell inThisBlock(int x, int y, int blockSize) {
        int a = (int) x / blockSize;
        int blockStartX = a * blockSize;
        a = (int) y / blockSize;
        int blockStartY = a * blockSize;
        return (new Cell(blockStartX, blockStartY));    
    }
    
}