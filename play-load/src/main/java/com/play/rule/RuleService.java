package com.play.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleService {

    private static final int AND = 1;

    private static final int OR = 0;

    private Map<Integer, List<BaseRule>> hashMap = new HashMap<>();


    public static RuleService create(){

        return new RuleService();
    }

    public RuleService add(List<BaseRule> ruleList){
        hashMap.put(AND,ruleList);
        return this;
    }


    public RuleService or(List<BaseRule> ruleList){
        hashMap.put(OR,ruleList);
        return this;
    }


    public boolean execute(RuleDto dto){

        for (Map.Entry<Integer,List<BaseRule>> item : hashMap.entrySet()){
            switch (item.getKey()){
                case AND:
                    System.out.println("execute key = " + 1);
                    if(!and(dto,item.getValue())){
                        return false;
                    }
                    break;
                case OR:
                    System.out.println("execute key = " + 0);
                    if(!or(dto , item.getValue())){
                        return false;
                    }
                    break;
                default:
                    break;
            }



        }
        return true;
    }


    private boolean and(RuleDto dto , List<BaseRule> ruleList){
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(dto);
            if(!execute){
                return false;
            }
        }
        return true;
    }

    private boolean or(RuleDto dto , List<BaseRule> ruleList){
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(dto);
            if(execute){
                return true;
            }

        }
        return false;
    }


}
