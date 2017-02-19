
package sudoku_Final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartGameUnlogged extends StartGame {
    
    protected RandomAccessFile randAccFile;
    
    
    public StartGameUnlogged(String typeOfGame) throws FileNotFoundException {
        randAccFile = new RandomAccessFile(typeOfGame + ".txt", "r");
    }
    
    private int selectGame() {
        Random r = new Random();
        return (r.nextInt(9));
    }
    
    @Override
    public int[][] loadGame() throws IOException {
        int gameToBeLoaded = selectGame();
        int positionToLoad = (gameToBeLoaded - 1) * 83;
        try {
            randAccFile.seek(positionToLoad);
        } catch (IOException ex) {
            Logger.getLogger(StartGameUnlogged.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int[][] game = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                int charCode = randAccFile.read();
                game[i][j] = Integer.parseInt(Character.toString ((char) charCode));
            }
        return game;
    }
}
