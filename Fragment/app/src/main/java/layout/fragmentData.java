package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.chrisrcsg.fragment.R;


public class fragmentData extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private EditText textData;
    private Button btnSend;

    private DataListener callback;
    public fragmentData() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            //Accedemos a la acciion generada en ata fragment
            // Y le notificamos a MainActivity
            callback = (DataListener)context;
        }
        catch (Exception i){
            throw new ClassCastException(context.toString()+ "Se debe implementar la interfaz DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_data,container,false);
        textData = (EditText)view.findViewById(R.id.text);
        btnSend = (Button) view.findViewById(R.id.btnsend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSend = textData.getText().toString();
                callback.sendData(textToSend);
            }
        });
        return  view;
    }

    public interface DataListener{
        void sendData(String text);

    }

}
