package com.adv;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adv.amfi.dao.RollingReturnsDAO;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class HomeController {

	@Autowired
	RollingReturnsDAO rollingReturnsDAO;
	
    @RequestMapping("/")
    public String home(Model model){

    	
    	model.addAttribute("page", "home");
    	
        return "layout/layout";
    }
    
    @GetMapping("/test")
    public String test(Model model) {
    	
    	ArrayList<String> list = new ArrayList<>();
    	 
        list.add("Baseball");
        list.add("Basketball");
        list.add("Cricket");
 
        model.addAttribute("list", list);

        return "test";
    }
    
    
    @RequestMapping("/checkout")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
    	
    	model.addAttribute("page", "home");
    	
    	
    	return "checkout";
    }
    
    @RequestMapping("/create-checkout-session")
    public void create_checkout_session(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
    	
    	try {
    	
    	Gson gson = new Gson();
    	Integer priceId = 1;
    		
    	model.addAttribute("page", "home");
    	
    	//secret key
    	Stripe.apiKey = "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";
    	
    	//api key
    	//Stripe.apiKey = "pk_live_51OAiZ0SHU3jRjxMLcYKuWRMrY5HYs1qLw4xPR8URkfy4faI6ljM4sASOzB8U4f0AH22XcJ6PnbgySAXvNQ8U3WAS00UiH2pXky";
    	
    	/*PaymentIntentCreateParams paymentIntentParams =
    	        PaymentIntentCreateParams.builder()
    	          .setAmount(10L)
    	          .setCurrency("inr")
    	      // In the latest version of the API, specifying the `automatic_payment_methods` parameter is optional because Stripe enables its functionality by default.
    	          .setAutomaticPaymentMethods(
    	            PaymentIntentCreateParams.AutomaticPaymentMethods
    	              .builder()
    	              .setEnabled(true)
    	              .build()
    	          )
    	          .build();

    	      // Create a PaymentIntent with the order amount and currency
    	      PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentParams);*/
    	
    	Map<String, Object> customerParams = new HashMap<>();
    	customerParams.put("description","My First Test Customer (created for API docs at https://www.stripe.com/docs/api)");
    	
    	String YOUR_DOMAIN = "http://localhost:8080";
 	    SessionCreateParams params =
 	      SessionCreateParams.builder()
 	      	.setClientReferenceId("12344")	      	
 	        .setCustomerEmail("karthick9686@gmail.com")
 	        .setMode(SessionCreateParams.Mode.PAYMENT)
 	        .setSuccessUrl(YOUR_DOMAIN + "/success")
 	        .setCancelUrl(YOUR_DOMAIN + "/cancel")
 	        .setCurrency("inr")
 	        
 	        .addLineItem(
 	          SessionCreateParams.LineItem.builder() 	          
 	            .setQuantity(1L)	           
 	            .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
 	                   .setCurrency("INR")
 	                  .setUnitAmount(200l)	
 	                 .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
 	                        .setName("MS Global Subscription")
 	                        .build())
 	                  .build())	         
 	            .build()
 	         )
 	        .build();
 	    
 	    Session session;
		
		session = Session.create(params);
		
		response.sendRedirect(session.getUrl());
			
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
   
    @RequestMapping("/success")
    public String success(HttpServletRequest request, HttpServletResponse response) {
    	
    	
    	Enumeration<String> params = request.getParameterNames(); 
    	while(params.hasMoreElements()){
    	 String paramName = params.nextElement();
    	 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
    	}
    	
    	return "success";
    }
    
    @RequestMapping("/cancel")
    public String cancel(HttpServletRequest request, HttpServletResponse response) {
    	
    	return "cancel";
    }
    
    
    
    
    

}