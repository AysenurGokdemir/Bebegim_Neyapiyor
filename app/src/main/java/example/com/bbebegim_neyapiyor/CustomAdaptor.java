package example.com.bbebegim_neyapiyor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by selin on 7/8/17.
 */

/**
 * Created by selin on 7/8/17.
 */

public class CustomAdaptor extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<Mesaj> mesajListe;
    FirebaseUser fUser;

    public CustomAdaptor(Activity activity, ArrayList<Mesaj> mesajListe,FirebaseUser fUser){
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mesajListe = mesajListe;
        this.fUser=fUser;
    }


    @Override
    public int getCount() {
        return mesajListe.size();
    }

    @Override
    public Object getItem(int position) {
        return mesajListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir;
        if (fUser.getEmail().equals(mesajListe.get(position).getGonderici())){
        satir = inflater.inflate(R.layout.custom_satir_sag,null);

        TextView tvGonderen = (TextView) satir.findViewById(R.id.textViewGonderenSag);
        TextView tvMesaj = (TextView) satir.findViewById(R.id.textViewMesajSag);
        TextView tvTarih = (TextView) satir.findViewById(R.id.textViewTarihSag);

        tvGonderen.setText(mesajListe.get(position).getGonderici());
        tvMesaj.setText(mesajListe.get(position).getMesajText());
        tvTarih.setText(mesajListe.get(position).getZaman());
        }else{
            satir = inflater.inflate(R.layout.custom_satir_sol,null);

            TextView tvGonderen = (TextView) satir.findViewById(R.id.textViewGonderenSol);
            TextView tvMesaj = (TextView) satir.findViewById(R.id.textViewMesajSol);
            TextView tvTarih = (TextView) satir.findViewById(R.id.textViewTarihSol);

            tvGonderen.setText(mesajListe.get(position).getGonderici());
            tvMesaj.setText(mesajListe.get(position).getMesajText());
            tvTarih.setText(mesajListe.get(position).getZaman());
        }


        return satir;
    }
}
