package com.minwoo.nunutalk;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NunutalkApplication {

    public static void main(String[] args) {

        // 1) .env 파일 로드
        Dotenv dotenv = Dotenv.configure().load();
        // 2) .env 파일에 적힌 properties 들을 현재 시스템에 적용
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(NunutalkApplication.class, args);
    }

}
