package player;

import token.Token;
import game.Board;
import game.Quarto;

import java.util.List;

public class AlphaBeta implements Player{

    private int depth;

    public AlphaBeta(int depth)
    {
        this.depth = depth;
    }


    public Token chooseMove(Token t, Quarto quarto)
    {
        return null;
    }
}
