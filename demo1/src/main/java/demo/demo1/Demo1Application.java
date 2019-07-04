package demo.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//逐层往下搜索各个加注解的类，例如写了一个jpa程序，会自动搜索加了@Entity注解的类。
@EnableAutoConfiguration
@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
