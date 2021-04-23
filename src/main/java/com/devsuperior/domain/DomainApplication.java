package com.devsuperior.domain;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.domain.entities.Client;
import com.devsuperior.domain.entities.Order;
import com.devsuperior.domain.entities.OrderItem;
import com.devsuperior.domain.entities.OrderStatus;
import com.devsuperior.domain.entities.Product;
import com.devsuperior.domain.repositories.ClientRepository;
import com.devsuperior.domain.repositories.OrderItemRepository;
import com.devsuperior.domain.repositories.OrderRepository;
import com.devsuperior.domain.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class DomainApplication implements CommandLineRunner{
	
	
	private ClientRepository clientRepository;
	private ProductRepository productRepository;
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Alan Pinho", "alanpinho@email.com");
		clientRepository.save(c1);
		
		Product p1 = new Product(null, "TV", 1000.0);
		Product p2 = new Product(null, "Mouse", 40.0);
		Product p3 = new Product(null, "PC", 1200.0);

		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Order o1 = new Order(null, Instant.parse("2021-04-18T11:25:09Z"),OrderStatus.PAID, c1, null, null);
		Order o2 = new Order(null, Instant.parse("2021-04-20T13:30:00Z"), OrderStatus.WAITING, c1, null, null);
		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		OrderItem i1 = new OrderItem(null, 1, 1000.0, o1, p1);
		OrderItem i2 = new OrderItem(null, 2, 40.0, o1, p2);
		OrderItem i3 = new OrderItem(null, 1, 40.0, o2, p2);
		OrderItem i4 = new OrderItem(null, 1, 1200.0, o2, p3);

		orderItemRepository.saveAll(Arrays.asList(i1, i2, i3, i4));
		
	}

}
