package com.best.projectB.service.fpv;

public abstract class AbstractFPV implements FPV{



    abstract void motors();

    @Override
    public void motor() {
        System.out.println("四颗电机");
        motors();
    }
}
