package rockr.elliottewing.com.rockr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        if(MainActivity.profile == null) MainActivity.profile = new UserProfile();

        /* Populate fields */
        ImageView imgView = (ImageView) view.findViewById(R.id.profpic_display);
        imgView.setImageURI(MainActivity.profile.getProfileImageUri());

        TextView textView = (TextView) view.findViewById(R.id.name_display);
        textView.setText(MainActivity.profile.getFirstName() + " " + MainActivity.profile.getLastName());

        textView = (TextView) view.findViewById(R.id.address_display);
        if(MainActivity.profile.getAddress() != null) {
            textView.setText(MainActivity.profile.getAddress().getAddressLine(0) + "\n" + MainActivity.profile.getAddress().getAddressLine(1) + "\n" + MainActivity.profile.getAddress().getAddressLine(2));
        }
        textView = (TextView) view.findViewById(R.id.bio_display);
        textView.setText(MainActivity.profile.getBiography());

        return view;
    }


}
