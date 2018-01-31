package com.mgassociates.bluefin.docs.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mgassociates.bluefin.docs.Adapters.StepsRecyclerViewAdapter;
import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;
import com.mgassociates.bluefin.docs.Utils.Validator;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StepsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StepsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StepsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView stepsRecyclerView;
    TextView comingSOonTextView;
    SubCategory mainOffice;

    private OnFragmentInteractionListener mListener;

    public StepsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StepsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StepsFragment newInstance(String param1, String param2) {
        StepsFragment fragment = new StepsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_steps, container, false);

        String mainID = getArguments().getString("subCategoryID");
        DatabaseHandler databaseHandler=new DatabaseHandler(getActivity());
        mainOffice=databaseHandler.getSubCategory(mainID);
        mainOffice=new Validator(getActivity()).validateSubCategory(mainOffice);

        comingSOonTextView=(TextView)rootView.findViewById(R.id.comingSoonTextView);
        stepsRecyclerView=(RecyclerView)rootView.findViewById(R.id.stepsRecyclerView);

        if(mainOffice.getSteps().size()==0){
                stepsRecyclerView.setVisibility(View.GONE);
                comingSOonTextView.setVisibility(View.VISIBLE);
        }

        else
        {
            stepsRecyclerView.setVisibility(View.VISIBLE);
            comingSOonTextView.setVisibility(View.GONE);
            initRecyclerVIew();
        }

        return rootView;
    }

    private void initRecyclerVIew() {

        StepsRecyclerViewAdapter adapter=new StepsRecyclerViewAdapter(getActivity(),mainOffice.getSteps());
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        stepsRecyclerView.setLayoutManager(manager);
        stepsRecyclerView.setAdapter(adapter);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
