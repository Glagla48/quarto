package game;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import player.Player;
import player.RandomPlayer;
import token.Token;

public class Quarto {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private List<Token> availableTokens;

    public Quarto()
    {
        this.board = new Board();
        this.players = new ArrayList<Player>();
        players.add(new RandomPlayer());
        players.add(new RandomPlayer());
        this.currentPlayer = this.players.get(0);

        this.availableTokens = Token.createListOfTokens();
    }

    public Player getCurrentPlayer(){ return this.currentPlayer;}

    public void switchCurrentPlayer()
    {
        int index = players.indexOf(this.currentPlayer);
        if(index == 1)
            this.currentPlayer = this.players.get(0);
        else
            this.currentPlayer = this.players.get(1);
    }

    public Player getWinner(){return this.currentPlayer;}

    private boolean isBoardFilled()
    {
        for(int x = 0; x <4; x++)
        {
            for(int y =0 ; y < 4; y++)
            {
                if(this.board.getToken(x, y) == null)
                    return false;
            }
        }
        return false;
    }

    private boolean isThereAValidSquare()
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(Token.hasSimilarity(this.board.getSquareBoard(x, y)))
                    return true;
            }
        }
        return false;
    }

    private boolean isThereAValidLine()
    {
        for(int x = 0; x < 4; x++)
        {
            if(Token.hasSimilarity(this.board.getLineBoard(x)) 
            || Token.hasSimilarity(this.board.getColumnBoard(x)))
                return true;
        }
        return false;
    }

    public boolean isAFullLineOrSquareComplete()
    {
        for(int x = 0; x < 4; x++)
        {
            if(Token.isComplete(this.board.getColumnBoard(x)) || Token.isComplete(this.board.getLineBoard(x)))
            {
                return true;
            }
            if(x < 3)
            {
                for(int y = 0; y < 3; y++)
                {
                    if(Token.isComplete(this.board.getSquareBoard(x, y)))
                        return true;
                }
            }
        }

        return false;
    }

    /*
    return si ya un gagnt ou si la board est pleine
     */
    public boolean isOver()
    {
        return isAFullLineOrSquareComplete() || isBoardFilled();
    }

    //TODO: Le jeu n'est adapté qu'au random player
    public void play()
    {
        int turn = 1;
        Random rand = new Random();

        Token tmpToken = this.availableTokens.get(rand.nextInt(this.availableTokens.size()));
        this.availableTokens.remove(0);

        while(true)
        {
            tmpToken = this.currentPlayer.chooseMove(tmpToken, this.availableTokens, this.board);
            turn++;
            if(turn > 4)
            {
                if(this.isOver())
                    break;
            }
            this.switchCurrentPlayer();
        }

        System.out.println("Le jeu est fini, cela a pris " + turn + "tours");
    }




}