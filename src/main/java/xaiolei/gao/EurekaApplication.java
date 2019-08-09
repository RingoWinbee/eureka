package xaiolei.gao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	public static String defaultPort = "8763";// 默认端口号

	public static void main(String[] args) {
		// 由于编译器的版本不同所以需要判断是不是最前面会默认有一个
		int i = 0;
		if (args.length == 2)
			i = 1;
		if (!"0".equals(args[i]))// 输入0表示端口号使用默认端口号,反之则不是
			defaultPort = args[i];
		new SpringApplicationBuilder(EurekaApplication.class).properties("server.port=" + defaultPort).run(args);
	}
}
