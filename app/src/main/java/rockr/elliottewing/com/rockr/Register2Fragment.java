package rockr.elliottewing.com.rockr;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RegisterFragment2Listener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Register2Fragment newInstance(String param1, String param2) {
        Register2Fragment fragment = new Register2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Register2Fragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_register2, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.genre_input);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.genres, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(MainActivity.profile.getPrimaryGenre() != null) {
            int position = adapter.getPosition(MainActivity.profile.getPrimaryGenre());
            spinner.setSelection(position);
        }

        spinner = (Spinner) view.findViewById(R.id.genre2_input);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.genres, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(MainActivity.profile.getPrimaryGenre() != null) {
            int position = adapter.getPosition(MainActivity.profile.getSecondaryGenre());
            spinner.setSelection(position);
        }

        spinner = (Spinner) view.findViewById(R.id.instrument_input);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.instruments, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(MainActivity.profile.getPrimaryGenre() != null) {
            int position = adapter.getPosition(MainActivity.profile.getPrimaryInstrument());
            spinner.setSelection(position);
        }

        spinner = (Spinner) view.findViewById(R.id.instrument2_input);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.instruments, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(MainActivity.profile.getPrimaryGenre() != null) {
            int position = adapter.getPosition(MainActivity.profile.getSecondaryInstrument());
            spinner.setSelection(position);
        }

        if(MainActivity.profile.getMusicProfile() != null) {
            EditText textView = (EditText) view.findViewById(R.id.musicbg_input);
            textView.setText(MainActivity.profile.getMusicProfile());
        }

        if(MainActivity.profile.getTopTracks() != null) {
            EditText textView = (EditText) view.findViewById(R.id.tracks_input);
            textView.setText(MainActivity.profile.getTopTracks());
        }

        Button nextButton = (Button) view.findViewById(R.id.button_submit);
        Button backButton = (Button) view.findViewById(R.id.button_back);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(MainActivity.profile == null) MainActivity.profile = new UserProfile();

                EditText textView = (EditText) getView().findViewById(R.id.musicbg_input);
                MainActivity.profile.setMusicProfile(textView.getText().toString());

                textView = (EditText) getView().findViewById(R.id.tracks_input);
                MainActivity.profile.setTopTracks(textView.getText().toString());

                Spinner spinner = (Spinner) getView().findViewById(R.id.genre_input);
                MainActivity.profile.setPrimaryGenre(spinner.getSelectedItem().toString());

                spinner = (Spinner) getView().findViewById(R.id.genre2_input);
                MainActivity.profile.setSecondaryGenre(spinner.getSelectedItem().toString());

                spinner = (Spinner) getView().findViewById(R.id.instrument_input);
                MainActivity.profile.setPrimaryInstrument(spinner.getSelectedItem().toString());

                spinner = (Spinner) getView().findViewById(R.id.instrument2_input);
                MainActivity.profile.setSecondaryInstrument(spinner.getSelectedItem().toString());

                Fragment frag = new Register3Fragment();

                FragmentManager fragManager = getActivity().getSupportFragmentManager();
                fragManager.beginTransaction().replace(R.id.container, frag).commit();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment frag = new RegisterFragment();

                FragmentManager fragManager = getActivity().getSupportFragmentManager();
                fragManager.beginTransaction().replace(R.id.container, frag).commit();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (RegisterFragment2Listener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface RegisterFragment2Listener {
        public void onRegisterFragment2Submit();
    }

}
