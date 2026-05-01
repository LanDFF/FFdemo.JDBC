package com.best.projectB.service;

import com.best.projectB.service.fpv.DjiFPV;
import com.best.projectB.service.fpv.FPV;
import com.best.projectB.service.fpv.MarioFPV;
import com.best.projectB.service.fpv.TjFPV;

public class FPVFactory {

    public FPV createFPV(String type){

        if ("DjiFPV".equals(type)){
            return new DjiFPV();
        }else if ("TjFPV".equals(type)){
            return new TjFPV();
        } else if ("MarioFPV".equals(type)) {
            return new MarioFPV();
        }
            throw new RuntimeException("没有对应FPV");
    }

}
