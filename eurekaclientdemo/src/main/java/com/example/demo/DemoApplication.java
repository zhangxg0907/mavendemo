package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.mapper.UserMapper;
import com.example.model.User;

//@SpringBootApplication
@EnableEurekaClient
@RestController
@MapperScan("com.example.mybatisspring.mapper")
//@MapperScan("com.winter.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

@Service
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( DemoApplication.class, args );
	}

	@Value("${server.port}")
	String port;
    //UserMapper.insert();
	//@Autowired
	//private UserMapper usermapper;//这里会报错，但是并不会影响
    //private User user;
	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
       //user.setUser("zxg");
        //usermapper.insert();
		return "hi " + name + " ,i am from port:" + port;
	}

}
