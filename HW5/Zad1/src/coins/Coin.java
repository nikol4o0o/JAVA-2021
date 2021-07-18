package coins;
import java.util.Random;

public class Coin
{
    //Random variable
    private Random rand;
    private Face face;

    public Coin(Face face)
    {
       setFace(face);
       this.rand = new Random();
    }

    public Face getFace()
    {
        return face;
    }

    public void setFace(Face face)
    {
        if(face != null)
        this.face = face;
        else this.face = Face.HEAD;
    }

    //Function to flip the coin
    public void flip()
    {
        if(rand.nextInt(2) == 1)
        {
            this.face = Face.HEAD;
        }
        else
        {
            this.face = Face.TAIL;
        }
    }

    public boolean isHeads()
    {
        return this.face == Face.HEAD;
    }

    @Override
    public String toString()
    {
        return String.format("Face %s", this.face.toString());
    }
}
