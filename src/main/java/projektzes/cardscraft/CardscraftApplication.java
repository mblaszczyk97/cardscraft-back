package projektzes.cardscraft;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projektzes.cardscraft.services.ParametersService;

@SpringBootApplication
public class CardscraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardscraftApplication.class, args);
	}


	@Autowired
	public ParametersService parametersService;

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter(parametersService));
		registrationBean.addUrlPatterns("/api/*");
		registrationBean.addUrlPatterns("/user/login");
		registrationBean.addUrlPatterns("/user/logout");
		registrationBean.addUrlPatterns("/user/check");

		return registrationBean;
	}

}
