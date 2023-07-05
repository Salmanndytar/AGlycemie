package com.ndytar.aglycemie.utils;

import java.time.LocalDateTime;

public class LocatTime {
   public static int tim(){
        int h=0;
        LocalDateTime localDateTime= LocalDateTime.now();
       h  = localDateTime.getHour();
        if (localDateTime.getHour() > 12 )
            h  = h - 12;
        int t = (h*360)
                +(localDateTime.getMinute()*60)
                +(localDateTime.getSecond());
        return t;
    }
}
