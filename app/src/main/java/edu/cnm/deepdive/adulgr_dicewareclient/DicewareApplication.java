package edu.cnm.deepdive.adulgr_dicewareclient;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class DicewareApplication extends Application {

  private static DicewareApplication instance;

  private GoogleSignInClient signInClient;
  private GoogleSignInAccount signInAccount;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestIdToken(getString(R.string.web_client_id))
        .build();
    signInClient = GoogleSignIn.getClient(this, options);
  }

  public static DicewareApplication getInstance() {
    return instance;
  }

  public GoogleSignInClient getSignInClient() {
    return signInClient;
  }

  public void setSignInClient(GoogleSignInClient signInClient) {
    this.signInClient = signInClient;
  }

  public GoogleSignInAccount getSignInAccount() {
    return signInAccount;
  }

  public void setSignInAccount(GoogleSignInAccount signInAccount) {
    this.signInAccount = signInAccount;
  }

}
