package player;

import token.Token;
import game.Board;
import game.Quarto;

import java.util.List;

public class MinMax implements Player{

    private int depth;

    public MinMax(int depth)
    {
        this.depth = depth;
    }

    public Token chooseMove(Token t, Quarto quarto)
    {
        return null;
    }

}