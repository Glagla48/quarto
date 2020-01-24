import game.Board;
import token.Token;

public class App{

    public static void main(String[] args) {
        Token.createListOfTokens();
        Board b = new Board();
        System.out.println(b.getToken(1, 1) == null);
    }
}