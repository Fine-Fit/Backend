package com.finefit.api.auth;



import com.finefit.api.auth.service.CustomUserDetailService;
import com.finefit.api.domain.model.type.TokenType;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private final SecretKey secretKey;
  public static final long ACCESS_TOKEN_EXPIRE_TIME = 60 * 60 * 1000L;  // 1시간
  public static final long REFRESH_TOKEN_EXPIRE_TIME = 24 * 60 * 60 * 1000L;  // 24시간
  private final CustomUserDetailService userDetailService;

  public JwtUtil(@Value("${spring.jwt.secret}")String secret,
      CustomUserDetailService userDetailService) {

    this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
        Jwts.SIG.HS256.key().build().getAlgorithm());

    this.userDetailService = userDetailService;
  }

  // userId 추출
  public Long getUserId(HttpServletRequest request) {
    String token = request.getHeader(TokenType.ACCESS.getValue());

    if(token.startsWith("Bearer ")) {
      token = token.substring(7);
    }
    return Jwts.parser().verifyWith(secretKey).build()
        .parseSignedClaims(token)
        .getPayload()
        .get("userId", Long.class);
  }

  // role 추출
  public String getRole(String token) {
    return Jwts.parser().verifyWith(secretKey).build()
        .parseSignedClaims(token)
        .getPayload()
        .get("role", String.class);
  }

  // UserDetails 조회 및 Authentication 객체 생성
  public Authentication getAuthentication(String userId) {
    UserDetails userDetails = userDetailService.loadUserByUsername(userId);

    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }

  // 토큰 만료기간 검증
  public boolean isExpired(String token) {
    try{
      Jwts.parser().verifyWith(secretKey).build()
          .parseSignedClaims(token)
          .getPayload()
          .getExpiration();

      return false;
    }catch (Exception e) {
      return true;
    }
  }

  // 토큰 생성
  public String createJwt(String type, Long userId) {
    long expirationTime = "access".equals(type)
        ? ACCESS_TOKEN_EXPIRE_TIME
        : REFRESH_TOKEN_EXPIRE_TIME;

    return Jwts.builder()
        .claim("type", type)
        .claim("userId", userId)
        .notBefore(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(secretKey)
        .compact();
  }

  public Cookie setCookie(String refresh) {
    Cookie cookie = new Cookie("refresh", refresh);
    cookie.setMaxAge(24 * 60 * 60 * 1000);
    cookie.setHttpOnly(true);

    return cookie;
  }
}


