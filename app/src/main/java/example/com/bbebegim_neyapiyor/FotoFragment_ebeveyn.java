package example.com.bbebegim_neyapiyor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Aysenur on 14.07.2017.
 */

public class FotoFragment_ebeveyn extends Fragment {

    View MyView;
    Button ebeveynFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyView=inflater.inflate(R.layout.foto_bilgisi_ebeveyn,container,false);
        ebeveynFoto= (Button) MyView.findViewById(R.id.ebeveyn_foto_gor);
        ebeveynFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MainActivityy.class);
                startActivity(intent);
            }
        });
        return MyView;
    }
}
