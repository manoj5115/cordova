package com.infrasoft.cordova.plugin;

import android.content.Intent;
import android.util.Log;

import com.infrasoft.book.MainActivity;
//import com.infrasoft.book.view.BookModel;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
//import org.apache.cordova.PluginResult;
import android.util.Log;
//import android.provider.Settings;
//import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import java.util.ArrayList;
//import java.util.List;

/**
 * Created by manoj.gupta on 05-11-2015.
 */

/**
 * This class implements a cordova plugin which shows page curl effect in Android when called from JavaScript code.
 */
public class PageCurlPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Log.e("PageCurlPlugin", "Cordova plugin invoked - " + data.toString());
        if (action.equals("showPageCurlEffect")) {
           /* String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;*/

            Intent intent = new Intent(this.cordova.getActivity(), MainActivity.class);
            intent.putExtra("data", data.toString());

            this.cordova.getActivity().startActivity(intent);
            callbackContext.success();

            return true;
        }
        return false;
    }

    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
