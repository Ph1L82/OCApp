package cl.philipsoft.ocapp.views.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.philipsoft.ocapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BudgetFragment extends Fragment {

    public static BudgetFragment newInstance() {
        return new BudgetFragment();
    }

    public BudgetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget, container, false);
    }

}
