package SpringBoot.FirstProject.member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MemberConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(MemberRepository repository) {
        return args -> {
            Member Andi = new Member(
                    "andi.castm@gmail.com",
                    "Andi",
                    "Castillo",
                    LocalDate.of(2000, Month.NOVEMBER,8)
            );

            Member John = new Member(
                    "jd@gmail.com",
                    "John",
                    "Doe",
                    LocalDate.of(1776, Month.JULY,4)
            );

            repository.saveAll(List.of(Andi, John)
            );
        };
    }
}
