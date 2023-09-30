package com.or2go.vendor.showstorenearme.storeList;

import android.content.Context;

import com.or2go.vendor.showstorenearme.AppEnv;

import java.util.ArrayList;

public class StoreManager {
    private Context mContext;
    AppEnv gAppEnv;
    Or2GoStore storeinfo;
    ArrayList<Or2GoStore> lActiveStoreList;

    public StoreManager(Context context) {
        this.mContext = context;
        gAppEnv = (AppEnv) context;
        lActiveStoreList = new ArrayList<Or2GoStore>();
    }

    public synchronized boolean addStoreInfo(Or2GoStore store){
        storeinfo = new Or2GoStore(store.vId, store.vName, store.vStoreType,
                store.geolocation, store.vContact);
        lActiveStoreList.add(storeinfo);
        return true;
    }

    public ArrayList<Or2GoStore> getStoreList() {
        return lActiveStoreList;
    }
}
