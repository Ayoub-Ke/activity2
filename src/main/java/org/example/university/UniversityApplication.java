package org.example.university;

import org.example.university.entities.Product;
import org.example.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    @Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//productRepository.save(new Product(null,"computer",4778,2));
		//productRepository.save(new Product(null,"computer 2",5220,5));
		List<Product> products = productRepository.findAll();
		products.forEach(p->
				System.out.println(p.toString()));
		Product product= productRepository.findById(Long.valueOf(2)).get();
		System.out.println("***************");
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println("***************");

		List<Product> productList=productRepository.findByNameContaining("C");
		productList.forEach(p->System.out.println(p));
		System.out.println("***********************************************");
		List<Product> productList2=productRepository.findByNameContaining("%C%");
		productList2.forEach(p->System.out.println(p));
		System.out.println("***********************************************");
		List<Product> productList3=productRepository.findByPriceGreaterThan(5000);
		productList3.forEach(p->System.out.println(p));


	}
}
