package com.adv;

import java.io.PrintWriter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adv.amfi.model.SchemeMapping;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ApiController {

	
	  static class CreatePaymentItem {
	    @SerializedName("id")
	    String id;

	    public String getId() {
	      return id;
	    }
	  }
	
	  static class CreatePayment {
	    @SerializedName("items")
	    CreatePaymentItem[] items;

	    public CreatePaymentItem[] getItems() {
	      return items;
	    }
	  }
	
	@GetMapping(value="/getAllSchemeCategories")
	public void getAllSchemeCategories(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		PrintWriter writer = null;		
		Gson gson = null;

		try 
		{
			writer = response.getWriter();
			gson = new Gson();
			response.setContentType("application/json");
			
		    // This is your test secret API key.
		    Stripe.apiKey = "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";


			

	
		      PaymentIntentCreateParams params =
		        PaymentIntentCreateParams.builder()
		          .setAmount(1L)
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
		      PaymentIntent paymentIntent = PaymentIntent.create(params);
	
		      
			
			
			
			
			
			
			SchemeMapping schemeMapping = new SchemeMapping();
			schemeMapping.setScheme_amfi_short_name("sadasdasdd");
			
    		writer.print(gson.toJson(schemeMapping));
		    writer.close();
		} 
		catch (Exception ex) 
		{
			
			ex.printStackTrace();
		}
	}
	
}
