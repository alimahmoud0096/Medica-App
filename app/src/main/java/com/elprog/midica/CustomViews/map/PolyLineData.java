package com.elprog.midica.CustomViews.map;

import com.google.android.gms.maps.model.Polyline;
import com.google.maps.model.DirectionsLeg;

import java.util.ArrayList;

public class PolyLineData {
    private static PolyLineData instance;
    private DirectionsLeg leg;
    private ArrayList<PolyLineData> polyLineDatalist;
    private Polyline polyline;

    private PolyLineData() {
        this.polyLineDatalist = new ArrayList<>();
    }

    public PolyLineData(Polyline polyline2, DirectionsLeg directionsLeg) {
        this.polyline = polyline2;
        this.leg = directionsLeg;
    }

    public static PolyLineData getInstance() {
        if (instance == null) {
            instance = new PolyLineData();
        }
        return instance;
    }

    public Polyline getPolyline() {
        return this.polyline;
    }

    public void setPolyline(Polyline polyline2) {
        this.polyline = polyline2;
    }

    public DirectionsLeg getLeg() {
        return this.leg;
    }

    public void setLeg(DirectionsLeg directionsLeg) {
        this.leg = directionsLeg;
    }

    public ArrayList<PolyLineData> getPolyLineDatalist() {
        return this.polyLineDatalist;
    }

    public String toString() {
        return "PolylineData{polyline=" + this.polyline + ", leg=" + this.leg + '}';
    }
}
