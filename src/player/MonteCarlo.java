package player;

import token.Token;
import game.Board;
import game.Quarto;

import java.util.List;

public class MonteCarlo implements Player{

    private int depth;

    public MonteCarlo(int depth)
    {
        this.depth = depth;
    }

    public Token chooseMove(Token t, Quarto quarto)
    {
        return null;
    }

}