import java.util.Observable;
import java.util.Observer;


public class Scoreboard implements Observer
{
    private FootballGame game;
    public Scoreboard(FootballGame game)
    {
        this.game = game;
        showScore();
        game.addObserver(this);
    }
    public void showScore()
    {
        System.out.println("SCOREBOARD: " + game.getScore());
    }
    public void update(Observable o, Object obj) {
        this.showScore();
    }
}