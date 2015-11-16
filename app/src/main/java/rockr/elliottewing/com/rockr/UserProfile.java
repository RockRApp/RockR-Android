package rockr.elliottewing.com.rockr;

import android.location.Address;
import android.media.Image;
import android.net.Uri;

/**
 * Created by Quentillionaire on 11/15/2015.
 */
public class UserProfile {
    private String firstName = null;
    private String lastName = null;
    private Address address = null;
    private String biography = null;
    private Uri profileImageUri = null;
    private String username = null;
    private String password = null; // NOT SECURE
    private String musicProfile = null;
    private String primaryGenre = null;
    private String secondaryGenre = null;
    private String primaryInstrument = null;
    private String secondaryInstrument = null;
    private String topTracks = null;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Uri getProfileImageUri() {
        return profileImageUri;
    }

    public void setProfileImageUri(Uri profileImageUri) {
        this.profileImageUri = profileImageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMusicProfile() {
        return musicProfile;
    }

    public void setMusicProfile(String musicProfile) {
        this.musicProfile = musicProfile;
    }

    public String getPrimaryGenre() {
        return primaryGenre;
    }

    public void setPrimaryGenre(String primaryGenre) {
        this.primaryGenre = primaryGenre;
    }

    public String getSecondaryGenre() {
        return secondaryGenre;
    }

    public void setSecondaryGenre(String secondaryGenre) {
        this.secondaryGenre = secondaryGenre;
    }

    public String getPrimaryInstrument() {
        return primaryInstrument;
    }

    public void setPrimaryInstrument(String primaryInstrument) {
        this.primaryInstrument = primaryInstrument;
    }

    public String getSecondaryInstrument() {
        return secondaryInstrument;
    }

    public void setSecondaryInstrument(String secondaryInstrument) {
        this.secondaryInstrument = secondaryInstrument;
    }

    public String getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(String topTracks) {
        this.topTracks = topTracks;
    }
}
