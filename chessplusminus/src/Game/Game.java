package Game;
//Game.java

public interface Game {
    public static final Player player1 = new Player(Color.WHITE, true);
    public static final Player player2 = new Player(Color.BLACK, false);

    public void game();
}
