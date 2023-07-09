package com.ndytar.aglycemie;

import com.ndytar.aglycemie.config.RsaKeyConfig;
import com.ndytar.aglycemie.services.AuthenticatService;
import com.ndytar.aglycemie.services.serviceImple.AuthenticatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.support.GroovyWebApplicationContext;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;


@EnableJpaAuditing
@EnableScheduling
@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfig.class)
public class AGlycemieApplication {

public static void main(String[] args)
{
    SpringApplication.run(AGlycemieApplication.class, args);
//    Instant  instant = Instant.now();
//    Instant expir =  Instant.parse("2023-07-05T02:45:41Z");
//   Integer va = null;
////
//    Random random = new Random();
//    ArrayList<Integer> code = new ArrayList<Integer>();
//    code.add(946978);
//    code.add(946970);
//    code.add(941078);
//   do {
//       va =random.nextInt(987654 - 543210)+543210;
//   }while (code.contains(va));
//   System.out.println("new code: "+va);
//    for (Integer i :code
//         ) {
//        System.out.println("code user: "+i);
//    }


    
}

}
