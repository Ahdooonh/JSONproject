package android.sas.ita.jsonproject;

import android.sas.ita.jsonproject.contacts.ContactsAdapter;
import android.sas.ita.jsonproject.contacts.ContactsOerson;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
private static final String JSONObjectURL="https://api.androidhive.info/contacts/";
    //private static final String JSONObjectURLWithImage="http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    public RequestQueue queue;
    public JsonObjectRequest objectrequest;
    ArrayList<ContactsOerson> contactsPeople;
    public static final String CONTACTS="contacts";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String EMAIL="email";
    public static final String ADDRESS="address";
    public static final String GENDER="gender";
    public static final String PHONE="phone";
    public static final String PHONE_HOME="home";
    public static final String PHONE_MOBILE="mobile";
    public static final String PHONE_OFFICE="office";
    RecyclerView recycler;
    ContactsAdapter contactsAdapter;
    ContactsOerson persone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler =(RecyclerView)findViewById(R.id.recycler);
        contactsPeople =new ArrayList<>();




        queue= Volley.newRequestQueue(this);
        objectrequest = new JsonObjectRequest(Request.Method.GET, JSONObjectURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray(CONTACTS);
                    //Log.d("response:-->",array.toString());

                    for(int i=0;i<array.length();i++)
                    {
                       JSONObject obj = array.getJSONObject(i);
                      String id= obj.getString(ID);
                        String name= obj.getString(NAME);
                        String address= obj.getString(ADDRESS);
                        String gender= obj.getString(GENDER);
                        String email= obj.getString(EMAIL);

                        JSONObject phone = obj.getJSONObject(PHONE);
                        String phone_mobile= phone.getString(PHONE_MOBILE);
                        String phone_home= phone.getString(PHONE_HOME);
                        String phone_office= phone.getString(PHONE_OFFICE);

                        persone = new ContactsOerson();
                        persone.setId(id);
                        persone.setName(name);
                        persone.setAddress(address);
                        persone.setGender(gender);
                        persone.setEmail(email);
                        persone.setPhone_mobile(phone_mobile);
                        persone.setPhone_home(phone_home);
                        persone.setPhone_office(phone_office);
                        contactsPeople.add(persone);

                    }
                    setAdapter(contactsPeople);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("reson of error:",error.getMessage());
            }
        });
        queue.add(objectrequest);
    }
    public void  setAdapter(ArrayList<ContactsOerson> contactsPeople){
        this.contactsPeople = contactsPeople;
        contactsAdapter = new ContactsAdapter(this,contactsPeople);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(contactsAdapter);
        contactsAdapter.notifyDataSetChanged();
    }
}
