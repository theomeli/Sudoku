/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku_Final;

/**
 *
 * @author Totoros
 */
public class DuidokuLogic extends SudokuLogic{
    protected int count;
   
    public DuidokuLogic(Board board, TypeOfSymbols symbols, int size) {
        super(board, symbols, size);
        count = 1;
    }
    
    public DuidokuLogic(Board board, TypeOfSymbols symbols, int size, StartGame game, String username) {
        super(board, symbols, size, game, username);
        count = 1;
    }
    
    @Override
    public void play(int x, int y, int number) {
        super.play(x, y, number);
        count++;
    }
    
}
