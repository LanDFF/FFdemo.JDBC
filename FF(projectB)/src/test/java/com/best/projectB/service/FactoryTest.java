package com.best.projectB.service;

import com.best.projectB.service.fpv.DjiFPV;
import com.best.projectB.service.fpv.FPV;
import org.junit.jupiter.api.Test;

import static com.best.projectB.service.fpv.DjiFPV.DJI;
import static com.best.projectB.service.fpv.MarioFPV.MARIO;
import static com.best.projectB.service.fpv.TjFPV.TJ;

public class FactoryTest {


    @Test
    public void testFactory(){
        FPVFactory fpvFactory = new FPVFactory();

        FPV fpv = fpvFactory.createFPV(DJI);

        fpv.print();

        fpv.frame();

        fpv.motor();

    }

}
