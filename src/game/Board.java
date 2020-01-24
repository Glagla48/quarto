package game;

import token.*;
import util.*;

import java.util.ArrayList;
import java.util.List;


public class Board{

    private Token[][] board;

    public Board(Token[][] board)
    {
        this.board = board;
    }

    public Board()
    {
        Token[][] board = new Token[4][4];
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                board[x][y] = null;
            }
        }
        this.board = board;
    }

    public void setBoard(Token[][] board){this.board = board;}
    public Token[][] getBoard(){return this.board;}

    public Token[] getLineBoard(int x){return this.board[x];}
    public Token[] getColumnBoard(int y)
    {
        Token[] ts = {this.board[0][y], this.board[1][y], this.board[2][y], this.board[3][y]};
        return ts;
    }

    public Token[] getSquareBoard(int x, int y)
    {
        Token[] res = {this.board[x][y], this.board[x+1][y], this.board[x][y+1], this.board[x+1][y+1]};
        return res;
    }

    public Token getToken(int x, int y){return this.board[x][y];}
    public void addToken(int x, int y, Token t){this.board[x][y] = t;}


    public List<Pair<Integer, Integer>> getEmptySlots()
    {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                if(this.board[x][y] == null)
                {
                    res.add(new Pair<Integer,Integer>(x, y));
                }
            }
        }

        return res;
    }



    public Board copy()
    {
        Token[][] newBoard = new Token[4][4];
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                board[x][y] = this.getToken(x, y);
            }
        }
        return new Board(newBoard);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o)
    {
        if(o instanceof Board)
        {
            Board board = (Board) o;
            for(int x = 0; x < 4; x++)
            {
                for(int y = 0; y < 4; y++)
                {
                    if(board.getToken(x, y).equals(this.getToken(x, y)))
                        continue;
                    else
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public String toString()
	{
			String a = "";
			for(int i = 0; i<4;i++){
				a+="[";
				for(int j = 0; j<4; j++){
					if(this.getToken(i,j)==null){
						a+="o";
					}else{
						a+="X";
					}
				}
				a+="]"+System.lineSeparator();
			}
			return a;
	}

}