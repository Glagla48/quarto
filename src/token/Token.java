package token;

import java.util.ArrayList;
import java.util.List;

public class Token{

    public final static String BLACK = "black";
    public final static String WHITE = "white";
    public final static String SMALL = "small";
    public final static String TALL = "tall";
    public final static String ROUNDED = "rounded";
    public final static String SQUARE = "square";
    public final static String FILLED = "filled";
    public final static String HOLE = "hole";

    public final static String[] color_ = {BLACK, WHITE};
    public final static String[] shape_ = {ROUNDED, SQUARE};
    public final static String[] size_ = {SMALL, TALL};
    public final static String[] peak_ = {FILLED, HOLE};

    private String color;
    private String size;
    private String shape;
    private String peak;

    public Token(String color, String size, String shape, String peak)
    {
        this.color = color;
        this.shape = shape;
        this.peak = peak;
        this.size = size;
    }

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public String getSize() {return size;}

    public void setSize(String size) {this.size = size;}

    public String getShape() {return shape;}

    public void setShape(String shape) {this.shape = shape;}

    public String getPeak() {return peak;}

    public void setPeak(String peak) {this.peak = peak;}


    /**
     * Creates and returns a List of all possible Token.
     * @return a List of all possible Token.
     */
    public static List<Token> createListOfTokens()
    {
        List<Token> res = new ArrayList<>();
        for(String color : color_)
        {
            for(String size : size_)
            {
                for(String shape : shape_)
                {
                    for(String peak : peak_)
                    {
                        res.add(new Token(color, size, shape, peak));
                    }
                }
            }
        }

        System.out.println(res.size());
        return res;
    }

    /* TODO: peut etre le truc de similarité est à revoir*/ 
    public boolean hasSimilarity(Token t)
    {
        return this.color.equals(t.getColor()) || this.shape.equals(t.getShape())
            || this.size.equals(t.getSize()) || this.peak.equals(t.getPeak());
    }

    private static boolean hasSameColor(Token[] ts)
    {
        int notNullIndex = 5;

        for(int i = 1; i < 4; i++)
        {
            if(ts[i] == null)
                continue;
            if(notNullIndex == 5 && ts[i] != null)
                notNullIndex = i;
            if(!ts[notNullIndex].getColor().equals(ts[i].getColor()))
                return false;
        } 
        return true;

    }
    private static boolean hasSameShape(Token[] ts)
    {
        int notNullIndex = 5;

        for(int i = 1; i < 4; i++)
        {
            if(ts[i] == null)
                continue;
            if(notNullIndex == 5 && ts[i] != null)
                notNullIndex = i;
            if(!ts[notNullIndex].getShape().equals(ts[i].getShape()))
                return false;
        } 
        return true;
    }
    private static boolean hasSameSize(Token[] ts)
    {
        int notNullIndex = 5;

        for(int i = 1; i < 4; i++)
        {
            if(ts[i] == null)
                continue;
            if(notNullIndex == 5 && ts[i] != null)
                notNullIndex = i;
            if(!ts[notNullIndex].getSize().equals(ts[i].getSize()))
                return false;
        } 
        return true;
        
    }
    private static boolean hasSamePeak(Token[] ts)
    {
        int notNullIndex = 5;

        for(int i = 0; i < 4; i++)
        {
            if(ts[i] == null)
                continue;
            if(notNullIndex == 5 && ts[i] != null)
                    notNullIndex = i;
            if(!ts[notNullIndex].getPeak().equals(ts[i].getPeak()))
                return false;
        } 
        return true;
    }

    /**
     * Checks if an array of Token has at least one similiraty.
     * @param ts array of Token.
     * @return true if the tokens have at least one similarity, false otherwise.
     */
    public static boolean hasSimilarity(Token[] ts)
    {
        return hasSameColor(ts) || hasSamePeak(ts) || hasSameShape(ts) || hasSameSize(ts);
    }

    public static boolean isComplete(Token[] ts)
    {
        int size = 0;

        for(int i = 0; i < ts.length; i++)
        {
            if(ts[i] != null)
                size++;
        }

        return size == 4 && Token.hasSimilarity(ts);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o)
    {
        if(o instanceof Token)
        {
            Token t = (Token) o;
            return this.color.equals(t.getColor()) && this.shape.equals(t.getShape())
            && this.size.equals(t.getSize()) && this.peak.equals(t.getPeak());
        }
        return false;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public String toString()
    {
		return "[ Le pion est : "+this.color+", "+this.shape+", "+this.peak+" et "+this.size+"]";
	}

    
    
}