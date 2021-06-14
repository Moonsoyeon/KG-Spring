import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.basic.ex01.Chef;
import com.spring.basic.ex01.Hotel;
import com.spring.basic.ex01.Restaurant;

public class MainClass {

	public static void main(String[] args) {
		/*Hotel hotel = new Hotel(new Restaurant(new Chef()));
		hotel.reserveRestaurant();*/
		
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:test-config.xml");
		
		Hotel hotel = ct.getBean("hotel", Hotel.class);
		hotel.reserveRestaurant();

	}

}
