package com.microservicesdemo.productservice.service;
import com.microservicesdemo.productservice.dto.ProductRequest;
import com.microservicesdemo.productservice.dto.ProductResponse;
import com.microservicesdemo.productservice.model.Product;
import com.microservicesdemo.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor //instead od creating constructor for all classes manually in complie time it will create the constructive for us in
@Slf4j //for logs
public class ProductService {

    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    //instance of product object
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName()).
                description(productRequest.getDescription()).price(productRequest.getPrice()).build();

        //save to db
        productRepository.save(product);
        log.info("Product {} is Saved" , product.getId());

    }


    public List<ProductResponse> getALLProducts() {

       List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

        //return null;
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId()).
                name(product.getName()).
                description(product.getDescription()).
                price(product.getPrice()).build();

    }
}
