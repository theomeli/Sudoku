
package sudoku_Final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;


public class StartGameLogged extends StartGameUnlogged{
    
    private final RandomAccessFile statLastSaved;          

    
  
    public StartGameLogged(String typeOfGame, String username) throws FileNotFoundException {
        super(typeOfGame);
        statLastSaved = new RandomAccessFile(username + typeOfGame + ".txt", "r");
    }
    
    private ArrayList<Integer> findGames() throws IOException {
        statLastSaved.seek(81);                                     
        ArrayList<Integer> gamesWin = new ArrayList<>();
        ArrayList<Integer> gamesToPlay = new ArrayList<>(); 
        gamesWin.add(statLastSaved.readInt());
        for (int i = 0; i < 9; i++)
            if (!gamesWin.contains(i))
                gamesToPlay.add(i);
        return gamesToPlay;
    }
    
    private int selectGame(ArrayList<Integer> gamesToPlay) {
        Random r = new Random(gamesToPlay.size());
        int gameSelected = r.nextInt();
        return gamesToPlay.get(gameSelected);
    }
    
        public int[][] loadGame(int gameSelected) throws IOException {
            randAccFile.seek(gameSelected * 81);
            int[][] game = new int[9][9];
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; i++)
                    game[i][j] = randAccFile.read();
            return game;
        }   
}
