
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.chrisrcsg.toolbarexample2.R;

/**
 * Created by ChrisRCSG on 27/06/17.
 */

public class FirstFragment extends Fragment {

    public FirstFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        return view;
    }
}