package hello.sample.tcnj.helloapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Arrays;
import java.util.List;

public class HelloWorldActivity extends ActionBarActivity {

    private Button button1;
    private Button button2;
    private TextView answer;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        listView = (ListView) findViewById(R.id.list);

        List<Candidate> candidates = Arrays.asList(new Candidate[]{new Candidate("Eirik Grieve", "red", 57), new Candidate("Jehosephet Armanni", "blue", 73), new Candidate("Reiner Samson", "red", 98), new Candidate("Socrates Hayden", "blue", 100)});

        CandidatesAdapter adapter = new CandidatesAdapter(this, candidates);

        listView.setAdapter(adapter);

        answer = (TextView)findViewById(R.id.text);


//        button1.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                setTextFromRESTService();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setTextFromRESTService()
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.justindilks.com/random_string_generator.html";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        answer.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                answer.setText("Couldn't connect!");
            }
        });
        queue.add(stringRequest);
    }
}
