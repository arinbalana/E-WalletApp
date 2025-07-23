package com.arin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication 
public class EWalletAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(EWalletAppApplication.class, args);
    }
}
//(exclude = { SecurityAutoConfiguration.class })
