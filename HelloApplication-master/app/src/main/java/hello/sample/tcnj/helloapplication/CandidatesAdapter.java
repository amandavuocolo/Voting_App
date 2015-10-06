package hello.sample.tcnj.helloapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import hello.sample.tcnj.helloapplication.Candidate;
import hello.sample.tcnj.helloapplication.R;

public class CandidatesAdapter extends ArrayAdapter<Candidate>
{
    public CandidatesAdapter(Context context, List<Candidate> candidates)
    {
        super(context, 0, candidates);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        final Candidate candidate = getItem(position);

        if (view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.candidate_entry, parent, false);
        }

        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                vote(candidate.getName());
            }
        });

        TextView candidateName = (TextView) view.findViewById(R.id.c_name);
        TextView candidateParty = (TextView) view.findViewById(R.id.c_party);
        TextView candidateVotes = (TextView) view.findViewById(R.id.c_votes);

        candidateName.setText(candidate.getName());
        candidateParty.setText(candidate.getParty());
        candidateVotes.setText(Integer.toString(candidate.getVotes()));

        return view;
    }

    public void vote(String candidate)
    {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url ="http://www.justindilks.com/vote.php?candidate=" + candidate;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("FAILURE");
                    }
                });
        queue.add(stringRequest);
    }
}