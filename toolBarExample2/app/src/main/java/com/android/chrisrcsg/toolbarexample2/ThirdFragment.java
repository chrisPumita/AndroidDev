
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.chrisrcsg.toolbarexample2.R;

/**
 * Created by ChrisRCSG on 27/06/17.
 */

public class ThirdFragment extends Fragment {

    public ThirdFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        return view;
    }
}