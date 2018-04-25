package com.fraudandroid;

import com.facebook.react.ReactActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

import com.iovation.mobile.android.FraudForceConfiguration;
import com.iovation.mobile.android.FraudForceManager;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "fraudandroid";
    }
public static String blackbox;
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blackbox = FraudForceManager.getInstance().getBlackbox(getApplicationContext());
        Log.v("<<<<<<<<<<<<<<<my blackbox from onCreate()", blackbox);

    }


     public void printDevice(View target) {

         new PrintThread().execute();
     }

    private class PrintThread extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
          //println(FraudForceManager.getInstance().getBlackbox(getApplicationContext()));
          //  return FraudForceManager.getInstance().getBlackbox(getApplicationContext());
          Log.v("<<<<<<<<<<<<<<<my blackbox from class PrintThread method doInBackGround()", blackbox);

          return blackbox;
        }

        @Override
        protected void onPostExecute(String bb) {
          Log.v("<<<<<<<<<<<<<<<my blackbox from class PrintThread method onPostExecute()", blackbox);

        }
     }

}
