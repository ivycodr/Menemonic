package com.mnemonic.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mnemonic.service.JWTService;

@ComponentScan("com.mnemonic.service")
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	
	JWTService jwtService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// check for matching header
		
		
		String header = request.getHeader("Authorization");
		if (header == null) {
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println("the header is " + header);
		StringBuffer pathRequestURL = request.getRequestURL();
		int index = pathRequestURL.indexOf("basicAuth/validate");
		// to make the h2-console work
		int indexH2 = pathRequestURL.indexOf("h2-console");
		if (indexH2 > 0 ) {
			chain.doFilter(request, response);
			return;
		}
//		int indexSwagger = pathRequestURL.indexOf("api-docs");
//		if (indexSwagger > 0 ) {
//			chain.doFilter(request, response);
//			return;
//		}
//		int indexSwaggerUI = pathRequestURL.indexOf("swagger-ui");
//		if (indexSwaggerUI > 0 ) {
//			chain.doFilter(request, response);
//			return;
//		}
		
		
		if ((header == null) || !header.startsWith("Bearer")) {
			
			if ((index > 0) && (header.startsWith("Basic"))) {
				chain.doFilter(request, response);
				return;
				
			}else if ((index < 0) && (header.startsWith("Basic"))) {
					return;
			
			}
			
			
			//http://localhost:8080/api/basicAuth/validate
			//int index = pathRequestURL.indexOf("basicAuth/validate");
			
			//chain.doFilter(request, response);
			//return;
		}
		
		
		if (jwtService == null) {
			ServletContext  servletContext = request.getServletContext();
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			jwtService = wac.getBean(JWTService.class);
			
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
		
		
		
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(String header) {
		// extract token
		
		String jwtToken = header.substring(7);
		System.out.println("the token is " + jwtToken);
		
		try {
			String payLoad = jwtService.validateToken(jwtToken);
			JsonParser parser = JsonParserFactory.getJsonParser();
			Map<String, Object> payLoadMap = parser.parseMap(payLoad);
			String user = payLoadMap.get("user").toString();
			String role = payLoadMap.get("role").toString();
			
			List<GrantedAuthority> roles = new ArrayList<>();
			GrantedAuthority ga = new GrantedAuthority() {
				
				@Override
				public String getAuthority() {
					return  role;
					
				}
				
			};
			
			roles.add(ga);
			
			return new UsernamePasswordAuthenticationToken (user, null, roles);
			
			
			
		}catch (Exception ex) {
			// token is null or not valid
			return null;
		}
		
		
		
	}
	
	
		
		
	
	
}
