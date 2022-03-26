package com.geely.design.principle.demeter;


public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader){
        teamLeader.checkNumberOfCource();
    }

}
