package android.sas.ita.jsonproject.country_module;

import android.sas.ita.jsonproject.contacts.ContactsAdapter;
import android.sas.ita.jsonproject.contacts.ContactsOerson;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.sas.ita.jsonproject.R;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {
    private static final String JSONObjectURLWithImage = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    public RequestQueue queue;
    public JsonObjectRequest objectrequest;
    ArrayList<CuntryJSON> contactsjson;
    public static final String worldpopulation = "worldpopulation";
    public static final String POPULATION = "population";
    public static final String RANK = "rank";
    public static final String FLAG = "flag";

    RecyclerView recycler;
    CountryAdapter countryAdapter;
    CuntryJSON cuntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        recycler = (RecyclerView) findViewById(R.id.recyclerr);
        contactsjson = new ArrayList<>();

        queue = Volley.newRequestQueue(this);
        objectrequest = new JsonObjectRequest(Request.Method.GET, JSONObjectURLWithImage, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray(worldpopulation);
                    Log.d("response:-->", array.toString());

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        String population = obj.getString(POPULATION);
                        int rank = obj.getInt(RANK);
                        String flag = obj.getString(FLAG);

                        cuntry = new CuntryJSON();
                        cuntry.setPopulation(population);
                        cuntry.setRank(rank);
                        cuntry.setImage(flag);
                        contactsjson.add(cuntry);

                    }
                    setAdapter(contactsjson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("reson of error:", error.getMessage());
            }
        });
        queue.add(objectrequest);
    }

    public void setAdapter(ArrayList<CuntryJSON> contactsPeople) {
        this.contactsjson = contactsjson;
        countryAdapter = new CountryAdapter(this, contactsjson);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(countryAdapter);
        countryAdapter.notifyDataSetChanged();
    }
}
