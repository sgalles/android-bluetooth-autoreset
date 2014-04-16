package com.sgalles.bluetoothautoreset;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothReseter extends BroadcastReceiver {
    private static final String TAG = "BluetoothReseter";

 
    /*public BluetoothReseter(Context context) {
        mContext = context;

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
        context.registerReceiver(this, filter);
    }*/


    @Override
    public void onReceive(Context context, Intent intent) {
    	//Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        //startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
    	Log.i(TAG, "Bleutooth=" + BluetoothAdapter.getDefaultAdapter().isEnabled());
        String action = intent.getAction();
        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            Log.i(TAG, "ACTION_STATE_CHANGED : " + state);
            //mEnabled = state == BluetoothAdapter.STATE_ON;
        } else if (action.equals(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED)) {
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_CONNECTION_STATE,
                BluetoothAdapter.STATE_DISCONNECTED);
            if (state == BluetoothAdapter.STATE_CONNECTED) {
            	Log.i(TAG, "ACTION_CONNECTION_STATE_CHANGED : CONNECTED");
               // mIconId = R.drawable.stat_sys_data_bluetooth_connected;
            } else {
            	Log.i(TAG, "ACTION_CONNECTION_STATE_CHANGED : DISCONNECTED");
                //mIconId = R.drawable.stat_sys_data_bluetooth;
            }
        }

    }
}