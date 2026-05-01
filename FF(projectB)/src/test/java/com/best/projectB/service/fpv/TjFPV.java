package com.best.projectB.service.fpv;

public class TjFPV extends AbstractFPV{



    public final static String TJ = "TjFPV";

    @Override
    public void print() {
        System.out.println("TjFPV");
    }

    @Override
    public void frame() {
        System.out.println("玻璃纤维");
    }

    @Override
    void motors() {
        System.out.println("杀马特2207");
    }

}
