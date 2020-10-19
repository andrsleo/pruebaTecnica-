package com.test.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.test.product.dto.ProductDTO;
import com.test.product.service.ProductService;

@RestController
public class ProductController {
	
	private static final String PRODUCTS = "/listproducts";
	
	@Autowired
	ProductService productService;
	
	/**
	 * Obtiene los productos del servicio API compartido a través de la petición GET
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(PRODUCTS)
	public ResponseEntity<Object> getProducts(){
		try {
			return ResponseEntity.ok(productService.getProductsService());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error get products", e);
		}
		
	}
	
	/**
	 * Envia el body del producto a buscar en la lista de productos y retorna el nombre del tipo del producto a través de la petición Post
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(PRODUCTS)
	public ResponseEntity<String> postProducts(@RequestBody ProductDTO productBody){
		try {
			return ResponseEntity.ok(productService.postProductsService(productBody));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error get products", e);
		}
		
	}
	
	/**
	 * Envia el body del producto a buscar en la lista de productos y retorna el objeto que se modificó en la petición Put
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(PRODUCTS)
	public ResponseEntity<Object> putProducts(@RequestBody ProductDTO productBody){
		try {
			return ResponseEntity.ok(productService.putProductsService(productBody));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error get products", e);
		}
		
	}
	
	/**
	 * Envia el body del producto a buscar en la lista de productos y retorna el nombre del tipo del producto a través de la petición Post
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping(PRODUCTS)
	public ResponseEntity<Object> deleteProducts(){
		try {
			return ResponseEntity.ok(productService.deleteProductsService());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error get products", e);
		}
		
	}

}
