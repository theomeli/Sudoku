/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku_Final;

import java.util.ArrayList;


public class ComputerPlay extends DuidokuLogic{
    
    public ComputerPlay(Board board, TypeOfSymbols symbol, int size) {
        super(board, symbol, size);
    }
    
    public ComputerPlay(Board board, TypeOfSymbols symbol, int size, StartGame game, String username) {
        super(board, symbol, size, game, username);
    }
    
    public void play(Board board) {
        ArrayList<Cell> positions = board.getEmptyCells();
        for (Cell position : positions){
            int x = position.getX();
            int y = position.getY();
        }
        count++;
    }
}
