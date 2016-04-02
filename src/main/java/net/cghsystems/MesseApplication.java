package net.cghsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class MesseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesseApplication.class, args);
    }

    @RequestMapping("jasmin/{jasmin}/chris/{chris}/value/{value}")
    public Result calculateFairness(@PathVariable("jasmin") float jasminEarnings,
                                    @PathVariable("chris") float chrisEarnings,
                                    @PathVariable("value") float value) {


        float totalEarnings = jasminEarnings + chrisEarnings;

        float chrisPercentage = (100 / totalEarnings) * chrisEarnings;
        float jasminPercentage = (100 / totalEarnings) * jasminEarnings;

        System.out.println("Chris Percentage: " + chrisPercentage);
        System.out.println("Jasmin Percentage: " + jasminPercentage);

        float jasminsContrib = (value/100) * jasminPercentage;
        float chrisContrib = (value/100) * chrisPercentage;

        String ret = "chris: " + chrisContrib;
        ret += "jasmin: " + jasminsContrib;

        return new Result(jasminsContrib, chrisContrib);
    }
}
