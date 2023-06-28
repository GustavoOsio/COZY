package com.Cozy.BakendCozy.Service;

import com.Cozy.BakendCozy.Entity.UsuarioLoginVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtAutenticacionFiltro extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JwtAutenticacionFiltro(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username != null && password != null) {
            logger.info("Usuario desde request parameter (form-data): " + username);
            logger.info("Password desde request parameter (form-data): " + password);
        } else {
            UsuarioLoginVo user = null;
            try {
                user = new ObjectMapper().readValue(request.getInputStream(), UsuarioLoginVo.class);
                username = user.getUser();
                password = user.getPassword();
                logger.info("Usuario desde request parameter (raw): " + username);
                logger.info("Password desde request parameter (raw): " + password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        username = username.trim();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String secretKeyString = "$2a$10$DIaePA39XOrinXhp9GO3q.698Sb8cmg..6b.yI8XiAXuJ3ObQ7YnWOsio";
        SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
        boolean estado = true;
        Claims claims = Jwts.claims();
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(authResult.getName())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setIssuedAt(new Date())
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        Map<String, Object> body = new HashMap<>();

        body.put("token", token);
        body.put("user", authResult.getName());
        body.put("ok", estado);
        body.put("mensaje", "Hola usuario, has iniciado sesión");
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        boolean estado = false;
        response.addHeader("Authorization", "Bearer ");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Error de autenticación: usuario o contraseña incorrectos!");
        body.put("error", failed.getMessage());
        body.put("ok", estado);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
    }
}
