package com.test.product.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.test.product.dto.ProductDTO;

@Service
public class ProductService {
	
	
	/**
	 * Realiza el proceso del consumo de la API https://testbankapi.firebaseio.com/products.json
	 * para obtener el json y los convierte en el objeto NamesTypesProductsDTO para ser retornado
	 * @return
	 */
	public Object getProductsService() {
		Object res1 = new Object();
		String json = new String();
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("https://testbankapi.firebaseio.com/products.json"))
              .GET()
              .build();
        
        
      try {
        HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
        json = respuesta.body();
        
        
      //Se valida la zona horaria a la cual se esta trabajando
		Gson gson = new GsonBuilder()
			    .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
			    	public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			           return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
			        }

					@Override
					public Date deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
							JsonDeserializationContext context) throws JsonParseException {
						return null;
					}
			     })
			     .create();
        
		res1 = gson.fromJson(json, Object.class);

      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }   
		
		
		return res1;
	}
	
	
	/**
	 * Retorna el String con el nombre del tipo de producto del consumo de la API https://testbankapi.firebaseio.com/products.json
	 * @return
	 */
	public String postProductsService(ProductDTO productBody) {
		
		String res = new String();
		Gson gson = new Gson();
		String productBodyJson = gson.toJson(productBody);
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("https://testbankapi.firebaseio.com/products.json"))
              .header("Content-Type", "application/json")
              .POST(BodyPublishers.ofString(productBodyJson))
              .build();
        
        
      try {
        HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
        res = respuesta.body();

      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }   
		
		return res;
		
	}
	
	/**
	 * Retorna el Object modificado del consumo de la API https://testbankapi.firebaseio.com/products/ -Lh7-wuYbP7AwpipuxNx.json
	 * @return
	 */
	public Object putProductsService(ProductDTO productBody) {
		
		Object res = new Object();
		Gson gson = new Gson();
		String productBodyJson = gson.toJson(productBody);
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("https://testbankapi.firebaseio.com/products/-Lh7-wuYbP7AwpipuxNx.json"))
              .header("Content-Type", "application/json")
              .PUT(BodyPublishers.ofString(productBodyJson))
              .build();
        
        
      try {
        HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
        String json = respuesta.body();
        
      //Se valida la zona horaria a la cual se esta trabajando
      		gson = new GsonBuilder()
      			    .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
      			    	public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
      			           return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
      			        }

      					@Override
      					public Date deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
      							JsonDeserializationContext context) throws JsonParseException {
      						return null;
      					}
      			     })
      			     .create();
              
      		res = gson.fromJson(json, Object.class);

      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }   
		
		return res;
		
	}
	
	/**
	 * Retorna el resultado de si elimino el producto o no 
	 * a través del consumo de la API https://testbankapi.firebaseio.com/products/ -Lh7-wuYbP7AwpipuxNx.json
	 * @return
	 */
	public Object deleteProductsService() {
		
		Object res = null;
		Gson gson = new Gson();
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("https://testbankapi.firebaseio.com/products/-Lh7-wuYbP7AwpipuxNx.json"))
              .DELETE()
              .build();
        
        
      try {
        HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
        String json = respuesta.body();
        
      //Se valida la zona horaria a la cual se esta trabajando
      		gson = new GsonBuilder()
      			    .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
      			    	public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
      			           return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
      			        }

      					@Override
      					public Date deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
      							JsonDeserializationContext context) throws JsonParseException {
      						return null;
      					}
      			     })
      			     .create();
              
      		res = gson.fromJson(json, Object.class);

      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }   
		
    	return res;
		
	}
	

}
