package rockr.elliottewing.com.rockr;

import android.location.Address;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.apache.commons.logging.Log;

public class MainActivity extends ActionBarActivity
        implements  LoginFragment.LoginFragmentListener,
                    RegisterFragment.RegisterFragment1Listener,
                    Register2Fragment.RegisterFragment2Listener,
                    Register3Fragment.RegisterFragment3Listener {

    public static UserProfile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Fragment loginFrag = new PreLoginFragment();

        FragmentManager fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.container, loginFrag).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }


    /** Fragment listener methods **/

    @Override
    public void onLoginFragmentSubmit() {

    }

    @Override
    public void onRegisterFragment2Submit() {

    }

    @Override
    public void onRegisterFragment3Submit() {

    }

    @Override
    public void onRegisterFragment1Submit(String firstName, String lastName, Address address, Uri pic, String user, String pass) {
        if(profile == null) profile = new UserProfile();
        profile.setName(firstName, lastName);
        profile.setAddress(address);
        profile.setProfileImageUri(pic);
        profile.setUsername(user);
        profile.setPassword(pass);
    }

    public UserProfile getCurrentProfile() {
        return profile;
    }
}
