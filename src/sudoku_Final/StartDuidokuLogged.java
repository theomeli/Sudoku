
package sudoku_Final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class StartDuidokuLogged extends StartGame {    
    
    private final RandomAccessFile statLastSaved;
    
    
    public StartDuidokuLogged(String username) throws FileNotFoundException {
        statLastSaved = new RandomAccessFile(username + ".txt", "r");
    }
    
    @Override
    public int[][] loadGame() throws IOException {
        int[][] game = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; i++)
                game[i][j] = statLastSaved.read();
        return game;
    }
}
