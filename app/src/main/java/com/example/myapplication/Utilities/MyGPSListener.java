package com.example.myapplication.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

public class MyGPSListener implements LocationListener {
    Context context;
    double latitude =0;
    double longitude =0;
    SharedPreferences saveLocation;
    public MyGPSListener(Context context) {
        this.context = context;
        saveLocation = context.getSharedPreferences("newLocation", Context.MODE_PRIVATE);
    }
    public void onLocationChanged(Location location) {
        if(saveLocation != null ) {
            double[] ll = new double[2];
            int i = 0;
            if(!saveLocation.getString("location", "").equals("")) {
                String locationStr =saveLocation.getString("location", null);
                StringTokenizer stringTokenizer = new StringTokenizer(locationStr, ":");
                while(stringTokenizer.hasMoreTokens()) {
                    String getDouble =stringTokenizer.nextToken();
                    ll[i] =Double.parseDouble(getDouble);
                    i++;
                }
                latitude = ll[0];
                longitude = ll[1];
                String message = "내 위치 -> Latitude : "+ latitude + "\nLongitude:"+ longitude;
                return;
            }
        }
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        String message = "내 위치 -> Latitude : "+ latitude + "\nLongitude:"+ longitude;
    }

    public void onProviderDisabled(String provider) { }

    public void onProviderEnabled(String provider) { }

    public void onStatusChanged(String provider, int status, Bundle extras) { }

    public LatLng startLocationService(TextView getAdress) {
        LocationManager manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        LatLng latLng= null;

        Location gpsProviderLocation;
        Location networkProviderLocation;

        long minTime = 2000;
        float minDistance = 0;

        try {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, this);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, this);

            gpsProviderLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            networkProviderLocation = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            String message = "내 위치 -> " + "location: "+ gpsProviderLocation +"\nlocation2:" + networkProviderLocation;
            Log.e("message_", message);
            Log.e("location :", saveLocation.getString("location", ""));
            if (gpsProviderLocation != null) {
                latitude = gpsProviderLocation.getLatitude();
                longitude = gpsProviderLocation.getLongitude();
                latLng = new LatLng(latitude, longitude);
            }
            else if (networkProviderLocation != null){
                latitude = networkProviderLocation.getLatitude();
                longitude = networkProviderLocation.getLongitude();
                latLng = new LatLng(latitude, longitude);
            }
            else {
                latitude = 37.49808785857802;
                longitude = 127.02758604547965;
                latLng = new LatLng(latitude, longitude);
            }
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
        return latLng;
    }
}
