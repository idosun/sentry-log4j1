package io.sentry.example;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Component
public class CustomFilter implements Filter {
	
	private static ArrayList<String> customTypes= new ArrayList<String>();
    static{
        customTypes.add("trial");
        customTypes.add("team");
        customTypes.add("business");
        customTypes.add("enterprise");
    }

    private String getCustomerType(){
        int r = (int) (Math.random() * (3));
        return customTypes.get(r);
    }


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        
		//Defined in sentry.properties - will be added as Tags
        MDC.put("customer_type", this.getCustomerType());
        
        //Not defined in sentry.properties - will be added to ADDITIONAL DATA 
        MDC.put("customKey3", "value3");
        
        
        chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
