package com.mow.mow;

import com.mow.mow.dao.*;
import com.mow.mow.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MowApplication {


	public static void main(String[] args) {
		SpringApplication.run(MowApplication.class, args);


/*
		Order order = new Order(1,1,23,"n","pizza veg");

		OrderService os = new OrderService();
		os.persist(order);


		RestaurantService rs = new RestaurantService();
		CategoryService cs = new CategoryService();
		SubCategoryService ss = new SubCategoryService();


		Restaurant r1 = new Restaurant();
		r1.setName("Express Chef");
		r1.setAdresa("Strada Scorțarilor 2");

		Category pizza = new Category();
		pizza.setName("Pizza");
		pizza.setRestaurant(r1);
		r1.getCategory().add(pizza);

		Category supa = new Category();
		supa.setName("Ciorba");
		supa.setRestaurant(r1);
		r1.getCategory().add(supa);

		SubCategory pizza1 = new SubCategory();
		pizza1.setName("pizza veg");
		pizza1.setPrice(23);
		pizza1.setRestaurant(r1);
		pizza1.setCategory(pizza);
		pizza.getSubcat().add(pizza1);

		for(SubCategory s:pizza.getSubcat())
			System.out.println(s.getName());

		rs.persist(r1);
		cs.persist(pizza);
		*/
		//ss.persist(pizza1);

	}

	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/").allowedOrigins("http://localhost:8080");
			}
		};
	}
*/
}
