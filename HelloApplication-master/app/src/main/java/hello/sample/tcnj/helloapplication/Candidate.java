package hello.sample.tcnj.helloapplication;

/**
 * Created by AmandaVuocolo on 9/22/2015.
 */
public class Candidate
{
    private String name;
    private String party;
    private int votes;

    public Candidate(String n, String p, int v)
    {
        name = n;
        party = p;
        votes = v;
    }

    public String getName()
    {
        return name;
    }

    public String getParty()
    {
        return party;
    }

    public int getVotes()
    {
        return votes;
    }
}
