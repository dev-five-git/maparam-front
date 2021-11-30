package com.example.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.Utilities.MyGPSListener;
import com.google.android.gms.maps.model.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.util.FusedLocationSource;

public class TimeLineMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapView mapView;
    NaverMap naverMap;
    MyGPSListener myGPSListener;
    LatLng myLatlng;
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
    public void getMyLocationRepeatly(){
        new Thread(new Runnable() {
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
                        }
                    });
                }

            }
        }).start();
    }
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        ActivityCompat.requestPermissions(this,PERMISSIONS,LOCATION_PERMISSION_REQUEST_CODE);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setCompassEnabled(true); // 나침반
        uiSettings.setScaleBarEnabled(true); // 거리
        uiSettings.setZoomControlEnabled(true); // 줌
        uiSettings.setLocationButtonEnabled(true); // 내가 있는곳
        com.naver.maps.geometry.LatLng naverLatLng;
        naverLatLng = new com.naver.maps.geometry.LatLng(myLatlng.latitude,myLatlng.longitude);
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(naverLatLng);
        naverMap.moveCamera(cameraUpdate);//        naverMap.locat

//        Log.e("kkk",locationSource.getLastLocation().getLatitude()+"dd");
//        LatLng whereAmI = new LatLng(locationSource.getLastLocation().getLatitude(),locationSource.getLastLocation().getLongitude());

//        LocationOverlay locationOverlay = naverMap.getLocationOverlay();
//        locationOverlay.setVisible(true);
//        UiSettings uiSettings = naverMap.getUiSettings();
//        uiSettings.setLocationButtonEnabled(true);
////        Marker marker = new Marker();
//        com.naver.maps.geometry.LatLng naverLatlng;
//        naverLatlng = new com.naver.maps.geometry.LatLng(myLatlng.latitude,myLatlng.longitude);
//        locationOverlay.setPosition(naverLatlng);
////        marker.setPosition(naverLatlng);
////        marker.setMap(naverMap);
//        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(naverLatlng);
//        naverMap.moveCamera(cameraUpdate);
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
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}