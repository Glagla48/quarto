package player;

import token.Token;
import game.Board;
import util.Pair;

import java.util.List;
import java.util.Random;


public class RandomPlayer implements Player{

    @Override
    public Token chooseMove(Token t,  List<Token> availableTokens, Board board)
    {
        Random rand = new Random();

        List<Pair<Integer, Integer>> availableSlots = board.getEmptySlots();
        Pair<Integer, Integer> coordinate = availableSlots.get(rand.nextInt(availableSlots.size()));
        board.addToken(coordinate.getKey(), coordinate.getValue(), t);

        int index = rand.nextInt(availableTokens.size());
        Token nextToken = availableTokens.get(index);
        availableTokens.remove(index);
        return nextToken;
    }
}