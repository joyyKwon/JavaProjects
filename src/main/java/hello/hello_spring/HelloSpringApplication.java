package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 이 SpringBootApplication 어노테이션이 있는 패키지 하위만 스캔한다.
// 컴포넌트 스캔 범위 : @SpringBootApplication 어노테이션 있는 패키지 하위
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
