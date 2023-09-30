package com.or2go.vendor.showstorenearme;

import static com.or2go.vendor.showstorenearme.storeList.Or2goConstValues.OR2GO_COMM_APPINFO;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.or2go.vendor.showstorenearme.storeList.GposCommManager;
import com.or2go.vendor.showstorenearme.storeList.StoreInfoCallback;
import com.or2go.vendor.showstorenearme.storeList.StoreManager;

public class AppEnv extends Application {
    GposCommManager gCommMgr;
    StoreManager gStoreMgr;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int startEnv(){
        gCommMgr = new GposCommManager(this);
        gStoreMgr = new StoreManager(this);
        InitServerComm();
        return 0;
    }

    public boolean InitServerComm() {
        if (!isInternetOn()) {
            Log.e("AppEnv", "AppEnv error ....no internet connection ");
            return false;
        }
        boolean iscommready = false;
        while (!iscommready) {
            if (gCommMgr.isAlive()) iscommready = true;
            else {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        startNewFunction();
        return true;
    }

    public GposCommManager getCommMgr() {
        return gCommMgr;
    }
    public StoreManager getStoreManager() {
        return gStoreMgr;
    }

    private void startNewFunction() {
        System.out.println("Get Here on function");
        Message msg = new Message();
        msg.what = OR2GO_COMM_APPINFO;//OR2GO_GET_SPINFO;	//fixed value for sending sales transaction to server
        msg.arg1 = 1;

        StoreInfoCallback appinfocb = new StoreInfoCallback(this);//Callback(mContext);

        Bundle b = new Bundle();
        b.putString("vendorid", "Or2Go_Test2");
        b.putParcelable("callback", appinfocb );
        msg.setData(b);
        gCommMgr.postMessage(msg);
    }

    public boolean isInternetOn() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec = (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connec.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            //Log.i("DataSyncTimerThread", "Internet is connected");
            return true;
        } else {
            //Log.i("DataSyncTimerThread", "No Internet connection");
            return false;
        }
    }
}
