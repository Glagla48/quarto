package player;

import token.Token;

import java.util.List;

import game.Board;
import game.Quarto;

public interface Player{

    /**
     * Allows a player to choose a move to play on the board.
     * @param t the Token to put on the board.
     * @param quarto an instance of the game.
     * @return the Token the next Player has to put on the board.
     */
    public Token chooseMove(Token t, Quarto quarto);

}