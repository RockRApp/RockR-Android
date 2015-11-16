package rockr.elliottewing.com.rockr;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.net.URI;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final int SELECT_PICTURE = 1;

    private Uri imgURI;

    // TODO: Rename and change types of parameters

    private String mParam1;
    private String mParam2;

    private RegisterFragment1Listener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterFragment() {
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
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        if(MainActivity.profile == null) MainActivity.profile = new UserProfile();

        UserProfile profile = MainActivity.profile;

        Spinner spinner = (Spinner) view.findViewById(R.id.state_input);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.states, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(profile != null && profile.getAddress() != null) {
            int position = adapter.getPosition(profile.getAddress().getAddressLine(2));
            spinner.setSelection(position);
        }

        spinner = (Spinner) view.findViewById(R.id.country_input);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.countries, R.layout.big_spinner);
        spinner.setAdapter(adapter);
        if(profile != null && profile.getAddress() != null) {
            int position = adapter.getPosition(profile.getAddress().getCountryName());
            spinner.setSelection(position);
        }

        if(profile != null) {
            EditText textField;

            if(profile.getFirstName() != null) {
                textField = (EditText) view.findViewById(R.id.firstname_input);
                textField.setText(profile.getFirstName());
            }

            if(profile.getLastName() != null) {
                textField = (EditText) view.findViewById(R.id.lastname_input);
                textField.setText(profile.getLastName());
            }

            if(profile.getAddress() != null) {
                textField = (EditText) view.findViewById(R.id.address_input);
                textField.setText(profile.getAddress().getAddressLine(0));

                textField = (EditText) view.findViewById(R.id.city_input);
                textField.setText(profile.getAddress().getAddressLine(1));
            }

            if(profile.getBiography() != null) {
                textField = (EditText) view.findViewById(R.id.bio_input);
                textField.setText(profile.getBiography());
            }


            if(profile.getUsername() != null) {
                textField = (EditText) view.findViewById(R.id.user_input);
                textField.setText(profile.getUsername());
            }


            if(profile.getPassword() != null) {
                textField = (EditText) view.findViewById(R.id.pass_input);
                textField.setText(profile.getPassword());
            }

        }

        ImageView imgView = (ImageView) view.findViewById(R.id.pic_view);
        if(profile.getProfileImageUri() != null)
            imgView.setImageURI(profile.getProfileImageUri());

        Button nextButton = (Button) view.findViewById(R.id.button_submit);
        Button backButton = (Button) view.findViewById(R.id.button_back);
        Button picButton = (Button) view.findViewById(R.id.button_picinput);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1, name2;
                EditText textField = (EditText) getView().findViewById(R.id.firstname_input);
                name1 = textField.getText().toString();

                textField = (EditText) getView().findViewById(R.id.lastname_input);
                name2 = textField.getText().toString();

                if(MainActivity.profile == null) MainActivity.profile = new UserProfile();

                MainActivity.profile.setName(name1, name2);

                textField = (EditText) getView().findViewById(R.id.user_input);
                MainActivity.profile.setUsername(textField.getText().toString());

                textField = (EditText) getView().findViewById(R.id.pass_input);
                MainActivity.profile.setPassword(textField.getText().toString());

                textField = (EditText) getView().findViewById(R.id.bio_input);
                MainActivity.profile.setBiography(textField.getText().toString());

                Address address = MainActivity.profile.getAddress();

                textField = (EditText) getView().findViewById(R.id.address_input);
                if(textField.getText() != null) {
                    if(address == null) address = new Address(Locale.US);
                    address.setAddressLine(0, textField.getText().toString());
                }

                textField = (EditText) getView().findViewById(R.id.city_input);
                if(textField.getText() != null) {
                    if(address == null) address = new Address(Locale.US);
                    address.setAddressLine(1, textField.getText().toString());
                }
                Spinner spin = (Spinner) getView().findViewById(R.id.state_input);
                if(spin.getSelectedItem().toString() != null) {
                    if(address == null) address = new Address(Locale.US);
                    address.setAddressLine(2, spin.getSelectedItem().toString());
                }

                spin = (Spinner) getView().findViewById(R.id.country_input);
                if(spin.getSelectedItem().toString() != null) {
                    if(address == null) address = new Address(Locale.US);
                    address.setCountryName(spin.getSelectedItem().toString());
                }

                MainActivity.profile.setProfileImageUri(imgURI);

                MainActivity.profile.setAddress(address);

                Fragment loginFrag = new Register2Fragment();

                FragmentManager fragManager = getActivity().getSupportFragmentManager();
                fragManager.beginTransaction().replace(R.id.container, loginFrag).commit();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment loginFrag = new PreLoginFragment();

                FragmentManager fragManager = getActivity().getSupportFragmentManager();
                fragManager.beginTransaction().replace(R.id.container, loginFrag).commit();
            }
        });

        picButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                imgURI = data.getData();

                ImageView img = (ImageView) getView().findViewById(R.id.pic_view);
                img.setImageURI(imgURI);
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (RegisterFragment1Listener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface RegisterFragment1Listener {
        public void onRegisterFragment1Submit(String firstName,
                                              String lastName,
                                              Address address,
                                              Uri pic,
                                              String user,
                                              String pass);
    }
}
