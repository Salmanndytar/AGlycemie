package com.ndytar.aglycemie.config;

import com.ndytar.aglycemie.utils.LocatTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableScheduling
@Configuration
public class CodeValidationConfig {

    public static Map<Object , Object> valCode = new HashMap<>();//Stocker les codes de validations generer pour user demande
    public static  Map<Object , Object> valMail = new HashMap<>();//Stoker son mail en lui envoyant le code

    @Bean
    @Scheduled(fixedRate = 30000)//chaque 30 seconde
    static public void runEachCurrentTime() {

        Map<Object , Object> suppval = new HashMap<>();//Map pour recuper tous les codes a duree plus de (ex: duree ex: 10) en verfiant chaque 30 sec
        /*
         * lancer la verification de duree d" stockage de code dans Map<> "valcode"
         * si la duree depasse 10 munite, recupere le code dans un autre map<> "suppval" afin de supprmer
         */
        clearMapContent(valCode,suppval,30);//la duree donee en minute
    }
    static void clearMapContent(Map<Object , Object> myMap, Map<Object , Object> suppval, int duree){
        suppval.clear();// chaque 30 seconde effacer supval

        String ky = "";
     
        for (Map.Entry<Object, Object> v : myMap.entrySet()){// parcourire les codes de validations stockes

            int  time = LocatTime.tim();//munite a l'instant
            /*
             * Calculer la duree
             */
            int temp = (Integer) v.getValue()+(duree*60);//convertir en sec

            if (time >= temp){
                ky = String.valueOf(v.getKey());
                suppval.put(v.getKey(),v.getValue());
            }
        }
        if (!ky.equals(""))
            for (Map.Entry<Object, Object> s : suppval.entrySet()){
                valMail.remove(s.getKey());//effacer les mails stocke coresspondant au code spire
                valCode.remove(s.getKey(),s.getValue());//effacer les codes stocke et spires
            }

    }
}
