package example.com.bbebegim_neyapiyor;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Aysenur on 22.07.2017.
 */

public class Bakici_Hakkinda extends Fragment {
    View view;
    private EditText adSoyad,evAdresi,tNo;
    private TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.bakici_hakkinda,container,false);
        adSoyad= (EditText) view.findViewById(R.id.ad_soyad);
        evAdresi= (EditText) view.findViewById(R.id.ev_adresi);
        tNo= (EditText) view.findViewById(R.id.telefon_numarasi);
        textView= (TextView) view.findViewById(R.id.bilgi);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }


}
