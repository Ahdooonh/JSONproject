package android.sas.ita.jsonproject.contacts;

import android.content.Context;
import android.provider.ContactsContract;
import android.sas.ita.jsonproject.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sasmob on 12/13/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    Context mContext;
    public ArrayList<ContactsOerson> contactsPeople;

    public ContactsAdapter(Context mContext, ArrayList<ContactsOerson> contactsPeople) {
        this.mContext = mContext;
        this.contactsPeople = contactsPeople;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View view=inflater.inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
       ContactsOerson person =contactsPeople.get(position);
        holder.name.setText(person.getName());
        holder.email.setText(person.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactsPeople.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.rank);
            email=(TextView) itemView.findViewById(R.id.population);
        }
    }
}
