package sudoku_Final;

import static java.lang.Math.sqrt;
import java.util.HashSet;

public class SudokuLogic {
   
    protected Board board; 
    protected TypeOfSymbols symbols;
    protected String username;
    
    
    public SudokuLogic(Board board, TypeOfSymbols symbols) {
        this.board = board;
        this.symbols = symbols;
        this.username = "-";                
    }
    
    public SudokuLogic(Board board, TypeOfSymbols symbols, String username) {
        this.board = board;
        this.symbols = symbols;
        this.username = username;
    }
    
    public void play(int x, int y, int number) {
        HashSet<Integer> numbsToPlay = allPossible(x, y); 
                if (numbsToPlay != null)
                    if (numbsToPlay.contains(number))
                        board.setCell(x, y, number);
    }
                
    
    public boolean isPossible(int x, int y, int cell) {
	int blockSize = (int) sqrt(this.board.getSize());
        int blockStartX = board.inThisBlock(x, y, blockSize).getX();      
        int blockStartY = board.inThisBlock(x, y, blockSize).getY();
        return (board.isCellEmpty(x, y) && board.isPossibleInX(x, y, cell) && board.isPossibleInY(x, y, cell)
                && board.isPossibleInBlock(x, y, blockStartX, blockStartY, blockSize, cell));
    }
    
    public HashSet<Integer> allPossible(int x, int y){
        HashSet<Integer> setOfPossible = new HashSet<>();
        for (Integer possibleCell : setOfPossible)
            if (isPossible(x, y, possibleCell))
                setOfPossible.add(possibleCell);
        return setOfPossible;
    }

    
}
