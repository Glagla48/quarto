package player;

import token.Token;

import java.util.List;

import game.Board;

public interface Player{

    /**
     * Allows a player to choose a move to play on the board.
     * @param t the Token to put on the board.
     * @param availableTokens the List composed of the Token that can be choosen to give to the oppponent.
     * @param board the Board of the game.
     * @return the Token the next Player has to put on the board.
     */
    public Token chooseMove(Token t, List<Token> availableTokens, Board board);

}