package com.example.lab5_ph35325;


public class PlacesModel {
    private String namePlace;
    private  int icPlace;

    public PlacesModel(int icPlace,String namePlace ) {

        this.icPlace = icPlace;
        this.namePlace = namePlace;
    }
    public PlacesModel(){}

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public int getIcPlace() {
        return icPlace;
    }

    public void setIcPlace(int icPlace) {
        this.icPlace = icPlace;
    }
}
