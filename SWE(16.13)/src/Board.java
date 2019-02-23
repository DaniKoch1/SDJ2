
public class Board {
	private Square[] squares;
	
	public Board(Square[] squares)
	{
		for(int i=0;i<40;i++)
		{
			this.squares[i]=squares[i].copy();
		}
	}
}
