package com.eshopping.product.dashboard.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JWTAuthenticationVerificationFilter extends BasicAuthenticationFilter {
	public JWTAuthenticationVerificationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("in
		// JWTAuthenticationVerificationFilter.doFilterInternal");
		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		// System.out.println(SecurityContextHolder.getContext());
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		// System.out.println("in
		// JWTAuthenticationVerificationFilter.UsernamePasswordAuthenticationToken");
		String token = request.getHeader("Authorization");
		// System.out.println("in username password authentication token method: the
		// token is " + token);
		if (token != null) {
			try {
				String user = JWT.require(Algorithm.HMAC512("SecretKeyToGenJWTs".getBytes())).build()
						.verify(token.replace("Bearer ", "")).getSubject();
				//System.out.println("user getname " + user);
				if (user != null) {
					// System.out.println(new UsernamePasswordAuthenticationToken(user, null, new
					// ArrayList<>()));
					return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
				}
			} catch (Exception ex) {
				throw new InvalidTokenException("Invalid token");
			}

			return null;
		}
		return null;
	}

}
