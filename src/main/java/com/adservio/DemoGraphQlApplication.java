package com.adservio;

import com.adservio.domain.Talent;
import com.adservio.service.TalentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphQlApplication.class, args);
    }

    @Bean
    ApplicationRunner init(TalentService talentService) {
        return args -> Stream.of("YEO;Soungalo", "ADDIA;Youssouf", "ASSI;Jean-Luc").forEach(couple -> {
            Talent talent = Talent.builder()
                    .firstname(couple.split(";")[0])
                    .lastname(couple.split(";")[1])
                    .startDate(LocalDate.now()).build();
            talentService.saveTalent(talent);
        });

    }

}
