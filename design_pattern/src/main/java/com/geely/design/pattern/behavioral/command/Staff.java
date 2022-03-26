package com.geely.design.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/16 10:38
 */

public class Staff {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void executeCommand(){
        commandList.forEach(Command::excute);
        commandList.clear();
    }


}
