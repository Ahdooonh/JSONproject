package android.sas.ita.jsonproject.country_module;

import android.content.Context;
import android.sas.ita.jsonproject.R;
import android.sas.ita.jsonproject.contacts.ContactsOerson;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sasmob on 12/13/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    Context mContext;
    public ArrayList<CuntryJSON> contactsjason;
    public CountryAdapter(Context mContext, ArrayList<CuntryJSON> contactsPeople) {
        this.mContext = mContext;
        this.contactsjason = contactsPeople;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.list_country,parent,false);

        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CuntryJSON person =contactsjason.get(position);
        holder.rank.setText(""+person.getRank());
        holder.population.setText(person.getPopulation());
        Picasso.with(mContext).load(person.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contactsjason.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rank, population;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            rank=(TextView) itemView.findViewById(R.id.rank);
            population=(TextView) itemView.findViewById(R.id.population);
            image=(ImageView) itemView.findViewById(R.id.image);
        }
    }
}
