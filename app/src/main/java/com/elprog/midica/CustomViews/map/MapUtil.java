package com.elprog.midica.CustomViews.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MapUtil {
    public static final int Error_Dialog_request = 9001;
    private static MapUtil instance;

    private MapUtil() {

    }

    public static MapUtil getInstance() {
        if (instance == null) {
            instance = new MapUtil();
        }
        return instance;
    }

    public void cameraViewAndAnimation(LatLngBounds.Builder builder, final GoogleMap googleMapp, int i, int i2) {
        LatLngBounds build = builder.build();
        double d = (double) i;
        Double.isNaN(d);
        googleMapp.animateCamera(CameraUpdateFactory.newLatLngBounds(build, i, i2, (int) (d * 0.1d)), new GoogleMap.CancelableCallback() {
            public void onCancel() {
            }

            public void onFinish() {
                GoogleMap googleMap = googleMapp;
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).bearing(30.0f).tilt(90.0f).build()));
            }
        });
    }

    public void animateCamera(LatLng latLng, final GoogleMap googleMapp) {
        googleMapp.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f), new GoogleMap.CancelableCallback() {
            public void onCancel() {
            }

            public void onFinish() {
                GoogleMap googleMap = googleMapp;
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).bearing(0.0f).tilt(45.0f).zoom(15.0f).build()));
            }
        });
    }

    @SuppressLint("WrongConstant")
    public boolean isMapServiceAvailable(Activity activity) {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GoogleApiAvailability.getInstance().isUserResolvableError(isGooglePlayServicesAvailable)) {
            GoogleApiAvailability.getInstance().getErrorDialog(activity, isGooglePlayServicesAvailable, Error_Dialog_request).show();
        } else {
            Toast.makeText(activity, "you can't access map requests", 0).show();
        }
        return false;
    }
}
