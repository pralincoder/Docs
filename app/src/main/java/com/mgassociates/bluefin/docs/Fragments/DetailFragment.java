package com.mgassociates.bluefin.docs.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;
import com.mgassociates.bluefin.docs.Utils.Validator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView emailAdress,officeName,phoneNumber,budget;
    LinearLayout seeDocuments,seeSteps;

    TabLayout tabLayout;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
        View rootView=inflater.inflate(R.layout.fragment_detail, container, false);

        String mainID = getArguments().getString("subCategoryID");
        DatabaseHandler databaseHandler=new DatabaseHandler(getActivity());
        SubCategory mainOffice=databaseHandler.getSubCategory(mainID);
        mainOffice=new Validator(getActivity()).validateSubCategory(mainOffice);

        emailAdress=(TextView) rootView.findViewById(R.id.emailAddressTExtView);
        officeName=(TextView)rootView.findViewById(R.id.subCategoryHeading);
        phoneNumber=(TextView)rootView.findViewById(R.id.phoneNumberTextView);
        budget=(TextView)rootView.findViewById(R.id.budgetTextVIew);
        seeDocuments=(LinearLayout)rootView.findViewById(R.id.seeRequiredDocumentsLL);
        seeSteps=(LinearLayout)rootView.findViewById(R.id.seeStepsLL);

        emailAdress.setText(mainOffice.getEmailAddress());
        officeName.setText(mainOffice.getSubCategoryName());
        phoneNumber.setText(mainOffice.getPhoneNumber());
        budget.setText("Rs  "+ mainOffice.getBudget());

        seeSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(getActivity(), DetailPageActivity.class);
//                i.putExtra("tabNumber",2);
//                startActivity(i);
                Toast.makeText(getActivity(), "Swipe 2 times to see Steps", Toast.LENGTH_SHORT).show();

            }
        });

        seeDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(getActivity(), DetailPageActivity.class);
//                i.putExtra("tabNumber",1);
//                startActivity(i);

                Toast.makeText(getActivity(), "Swipe 1 times to see Steps", Toast.LENGTH_SHORT).show();


            }
        });


        return rootView;
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
