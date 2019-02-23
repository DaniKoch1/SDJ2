import java.util.Observable;
import java.util.Observer;

public class ScoreBoard implements Observer{
	private FootballGame game;

	public ScoreBoard(FootballGame game) {
		this.game = game;
		game.addObserver(this);
		showScore();
	}
	public void showScore() {
		System.out.println("SCOREBOARD: " + game.getScore());
	}
	@Override
	public void update(Observable o, Object arg) {
		showScore();
		
	}
}
