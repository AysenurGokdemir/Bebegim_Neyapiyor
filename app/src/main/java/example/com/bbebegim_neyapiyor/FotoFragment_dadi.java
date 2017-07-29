package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Aysenur on 13.07.2017.
 */

public class FotoFragment_dadi extends Fragment {

    View MyView;
    Button dadiFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyView = inflater.inflate(R.layout.fotograf_ekle_dadi_adminlayout, container, false);
        dadiFoto= (Button) MyView.findViewById(R.id.foto_yukle);
        dadiFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MainActivityy.class);
                startActivity(intent);
            }
        });
        return MyView;

    }

}

