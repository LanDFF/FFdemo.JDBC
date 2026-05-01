package com.best.projectB.service.fpv;

public class DjiFPV extends AbstractFPV{



    public final static String DJI = "DjiFPV";

    @Override
    public void print() {
        System.out.println("DjiFPV");
    }

    @Override
    public void frame() {
        System.out.println("ABS");
    }

    @Override
    void motors() {
        System.out.println("DJI大力神");
    }


}
