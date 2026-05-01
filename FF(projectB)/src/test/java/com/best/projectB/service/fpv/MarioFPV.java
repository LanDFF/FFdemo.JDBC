package com.best.projectB.service.fpv;

public class MarioFPV extends AbstractFPV{



    public final static String MARIO = "MarioFPV";

    @Override
    public void print() {
        System.out.println("MarioFPV");
    }

    @Override
    public void frame() {
        System.out.println("碳纤维");
    }

    @Override
    void motors() {
        System.out.println("蓝色妖姬2306");
    }


}
