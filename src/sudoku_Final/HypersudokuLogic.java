package sudoku_Final;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Totoros
 */
public class HypersudokuLogic extends SudokuLogic{

    public HypersudokuLogic(Board board, TypeOfSymbols symbols, int size) {
        super(board, symbols, size);
    }
    
    public HypersudokuLogic(Board board, TypeOfSymbols symbols, int size, StartGame game, String username) {
        super(board, symbols, size, game, username);
    }
    
    public Cell inThisExtraBlock(int x, int y) {
        return null;
    }
    
    public boolean isInExtraBlock(int x, int y) {
        return (inThisExtraBlock(x, y) != null);
    }
    
    public boolean isPossibleInExtra(int x, int y, int number) {  
        if (isInExtraBlock(x, y)) {
            int blockStartX = inThisExtraBlock(x, y).getX();
            int blockStartY = inThisExtraBlock(x, y).getY();
            return(board.isPossibleInBlock(x, y, blockStartX, blockStartY, 3, number));
        }    
        return true;
    }
   
    @Override
    public boolean isPossible(int x, int y, int number) {
        if (super.isPossible(x, y, number))
            if (isInExtraBlock(x, y))
                if (isPossibleInExtra(x, y, number))
                    return true;
        return false;
    }
}
