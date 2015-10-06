package hello.sample.tcnj.helloapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AmandaVuocolo on 9/22/2015.
 */
public class CandidateViewAdapter extends ArrayAdapter<Candidate>
{
    public CandidateViewAdapter(Context context, List<Candidate> candidates)
    {
        super(context, 0, candidates);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        Candidate candidate = getItem(position);

        if (view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.candidate_view, parent, false);
        }

        TextView candidateName = (TextView) view.findViewById(R.id.candidateName);
        TextView candidateParty = (TextView) view.findViewById(R.id.candidateParty);
        TextView candidateVotes = (TextView) view.findViewById(R.id.candidateVotes);

        candidateName.setText(candidate.getName());
        candidateParty.setText(candidate.getParty());
        candidateVotes.setText(Integer.toString(candidate.getVotes()));

        return view;
    }
}
