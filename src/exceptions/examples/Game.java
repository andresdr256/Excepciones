package exceptions.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.*;

public class Game {
    public void saveGame() {
        try{
            saveProgress();
            saveScore();
            saveStatistics();
        } catch(SaveProgressException ex){
            System.err.println("Can´t save progress. " + ex.getMessage());
        } catch (SaveScoreException ex) {
            System.err.println("Can´t save score. " + ex.getMessage());
        }
    }

    private void saveStatistics() {

    }

    private void saveScore() throws SaveScoreException{
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm/ss");

            writer = new FileWriter("Score.txt", true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            writer.close();
        } catch (IOException e) {
            throw new SaveScoreException();
        } finally{
            if(writer != null){
                try{
                    writer.close();
                } catch(IOException e){
                    System.out.println("Can't save score");
                }
            }
        }
    }

    private void saveProgress() throws SaveProgressException{
        FileWriter writer = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm/ss");

            writer = new FileWriter("Progress.txt", true);

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());

            writer.close();
        } catch (IOException e) {
            throw new SaveProgressException();
        } finally{
            if(writer != null){
                try{
                    writer.close();
                } catch(IOException e){
                    System.out.println("Can't save progreso");
                }
            }
        }
    }
}
