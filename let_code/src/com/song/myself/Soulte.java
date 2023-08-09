package com.song.myself;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName Soulte
 * @Description TODO
 * @Author szh
 * @Date 2022年11月25日
 */
public class Soulte {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        Date date = sf.parse("202203");


        LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println(date);

        System.out.println(date1);


        LocalDate now = LocalDate.now();

        System.out.println(now.getDayOfMonth());


    }



}
