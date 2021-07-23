package events;

public class AlarmEvent
{
    private int nrings;

    public AlarmEvent(int nrings)
    {
    }

    public int getNrings()
    {
        return nrings;
    }

    public void setNrings(int nrings)
    {
        if(nrings >= 0)
        {
            this.nrings = nrings;
        }
        else
        {
            this.nrings = 0;
        }
    }
}
