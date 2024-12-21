public class Main {
    public static void main(String[] args) {
        Player raquel = new Player("Raquel");
        Player mario = new Player("Mario");

        Game game = new Game(raquel, mario);

        game.start();






    }
}