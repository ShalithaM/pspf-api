package org.pspf.helpers;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.pspf.exceptions.UnAuthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenManager {

	public static final String ROLE = "a";
	public static final String USERNAME = "b";
	public static final String TOKEN_DATA = "c";
	public static final String PENSION_POINT = "d";

	private final String SECTRET = "0a6b944d-d2fb-46fc-a85e-0295c986cd9f";

	private static long id = 0;

	/**
	 * generate the token for the user
	 * 
	 * @param username
	 * @param role
	 * @return
	 */
	public String generateToken(String username, String role, int pensionPointId) {
		
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		//Let's set the JWT Claims
		JwtBuilder builder = null;
		try {
			builder = Jwts.builder().setId(String.valueOf(id++))
					.setIssuedAt(now)
					.setSubject("auth_token")
					.setIssuer("pensiondpt")
					.claim(USERNAME, username)
					.claim(ROLE, role)
					.claim(PENSION_POINT, pensionPointId)
					.signWith(SignatureAlgorithm.HS256, SECTRET.getBytes("UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//if it has been specified, let's add the expiration
		long expMillis = nowMillis + 3600000 * 8;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp);

		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	/**
	 * validate the token return the claim is the token is valid throw
	 * UnAuthorizedException if the token is not valid
	 * 
	 * @param token
	 * @return
	 */
	public Claims isValidToken(String token) {
		Claims claim = null;
		try {
			claim = Jwts.parser().setSigningKey(SECTRET.getBytes("UTF-8"))
					.parseClaimsJws(token).getBody();

		} catch (ExpiredJwtException e) {
			System.out.println("token expired");
			throw new UnAuthorizedException("Session time out");
		} catch (Exception e) {
			System.out.println("invalid token");
			throw new UnAuthorizedException(
					"User is not authorized..login to the system");
		}

		return claim;
	}

}
