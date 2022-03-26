package com.geely.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {

    public void checkNumberOfCource(){
        List<Cource> courceList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courceList.add(new Cource());
        }
        System.out.println("在线课程的数量是："+ courceList.size());
    }

}
