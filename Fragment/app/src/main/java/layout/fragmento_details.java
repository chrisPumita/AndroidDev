package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.chrisrcsg.fragment.R;


public class fragmento_details extends Fragment {
    private TextView details;

    public fragmento_details(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_data,container,false);
        details = (TextView)view.findViewById(R.id.textViewDetails);
        return view;
    }

    public  void rederText(String text){
        details.setText(text);
    }

}
