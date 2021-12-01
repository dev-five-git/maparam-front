package com.example.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Dialog.MapMarkerClickDialog;
import com.example.myapplication.Model.MapTimeLineModel;
import com.example.myapplication.ModelShell.MapTimeLineShellModel;
import com.example.myapplication.R;
import com.example.myapplication.Utilities.MyGPSListener;
import com.example.myapplication.Utilities.UrlMaker;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TimeLineMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static String TAG = "TimeLineMapActivity";
    private static int ZOOM_DISTANCE = 500; //500 meter level 13 = 500 m
    private static int ZOOM_MULTIPLE= 30;
    //default lat 37.492218333333334 default lon 126.94948833333333
    MapView mapView;
    NaverMap naverMap;
    MyGPSListener myGPSListener;
    LatLng myLatlng;
    Thread dataThread;
    MapTimeLineShellModel data;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line_map);
        mapView = findViewById(R.id.map_view);
        mapView.getMapAsync(this);
        myGPSListener = new MyGPSListener(this);
        myLatlng = myGPSListener.startLocationService(null);
        getMyLocationRepeatly();

        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
    }
    public void getPostData(LatLng latLng){
        HashMap<String,Double> hashMap = new HashMap<>();
        hashMap.put("location_latitude",latLng.latitude);
        hashMap.put("location_longitude",latLng.longitude);
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(latLng.latitude);
            jsonArray.put(latLng.longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String url = new UrlMaker().UrlMake("/v1/timeline/gps?distance="+ZOOM_DISTANCE*ZOOM_MULTIPLE);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG,response.toString());
                        Gson gson = new Gson();
                        data = gson.fromJson(response.toString(),MapTimeLineShellModel.class);
                        Log.e("술",data.getBoard_list().size()+"");
                        makePins(data);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("distance", ZOOM_DISTANCE*ZOOM_MULTIPLE+"");
                return map;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void makePins(MapTimeLineShellModel models){
        for (MapTimeLineModel item : models.getBoard_list()) {
            Marker marker = new Marker();
            com.naver.maps.geometry.LatLng boardLatLng = new com.naver.maps.geometry.LatLng(item.getLocation_latitude(),item.getLocation_longitude());
            marker.setPosition(boardLatLng);
            int height = getResources().getDrawable(R.drawable.map_marker).getIntrinsicHeight() / 4;
            int width = getResources().getDrawable(R.drawable.map_marker).getIntrinsicWidth() / 4;
            BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.map_marker);
            Bitmap b = bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
            marker.setIcon(OverlayImage.fromBitmap(smallMarker));
            marker.setMap(naverMap);

            marker.setOnClickListener(new Overlay.OnClickListener() {
                @Override
                public boolean onClick(@NonNull Overlay overlay) {
                    MapMarkerClickDialog dialog = new MapMarkerClickDialog(TimeLineMapActivity.this,item);
                    dialog.callFunction();
                    return false;
                }
            });
        }
    }
    public void getMyLocationRepeatly(){
        dataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myLatlng = myGPSListener.startLocationService(null);
                            Log.e(TAG,myLatlng.latitude+"");
                            Log.e(TAG,myLatlng.longitude+"");
                            getPostData(myLatlng);
                        }
                    });
                }

            }
        });
        dataThread.start();
    }
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        ActivityCompat.requestPermissions(this,PERMISSIONS,LOCATION_PERMISSION_REQUEST_CODE);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setCompassEnabled(true); // 나침반
        uiSettings.setScaleBarEnabled(true); // 거리
        uiSettings.setZoomControlEnabled(false); // 줌
        uiSettings.setLocationButtonEnabled(false); // 내가 있는곳
        uiSettings.setScrollGesturesEnabled(false);
        uiSettings.setRotateGesturesEnabled(false);
        com.naver.maps.geometry.LatLng naverLatLng;
        naverMap.setMaxZoom(13);
        naverMap.setMinZoom(13);
        myLatlng = myGPSListener.startLocationService(null);
        naverLatLng = new com.naver.maps.geometry.LatLng(myLatlng.latitude,myLatlng.longitude);
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(naverLatLng);
        naverMap.moveCamera(cameraUpdate);//        n
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) { // 권한 거부됨
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            }else{
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

//                CameraUpdate cameraUpdate =CameraUpdate.scrollTo(whereAmI);
//                naverMap.moveCamera(cameraUpdate);
            }

        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
        dataThread.interrupt();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        dataThread.interrupt();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}