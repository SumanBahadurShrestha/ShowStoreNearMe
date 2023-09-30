package com.or2go.vendor.showstorenearme.storeList;

public class Or2GoStore {
    public String vId;
    public String vStoreType;
    public String vName;
    public String geolocation;
    public String vContact;

    public Or2GoStore(String id, String name, String storetype, String geoLocation, String contact) {
        this.vId = id;
        this.vName = name;
        this.vStoreType = storetype;
        this.vContact = contact;
        this.geolocation = geoLocation;
    }

    public String getvId() {
        return vId;
    }

    public String getvStoreType() {
        return vStoreType;
    }

    public String getvName() {
        return vName;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public String getvContact() {
        return vContact;
    }
}
