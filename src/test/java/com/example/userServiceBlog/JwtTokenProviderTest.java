//package com.example.userServiceBlog;
//
//import com.example.userServiceBlog.config.JwtTokenProvider;
//import com.example.userServiceBlog.modelDB.User;
//import io.jsonwebtoken.security.Keys;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.crypto.SecretKey;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JwtTokenProviderTest {
//
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Value("${jwt.secret}")
//    private String jwtSecret = "ThisIsASecretKeyForJWTThatMustBeAtLeast256BitsLong!";
//
//    @Value("${jwt.expiration}")
//    private long jwtExpiration = 3600000; // 1 час
//
////    @BeforeEach
////    void setUp() {
////        jwtTokenProvider = new JwtTokenProvider();
////        jwtTokenProvider.jwtSecret = jwtSecret;
////        jwtTokenProvider.jwtExpiration = jwtExpiration;
////    }
//
//    @Test
//    void testCreateToken() {
//        String username = "john_doe";
//        String roles = "ROLE_USER";
//
//        String token = jwtTokenProvider.createToken(username, roles);
//        assertNotNull(token);
//
//        String extractedUsername = jwtTokenProvider.getUsername(token);
//        assertEquals(username, extractedUsername);
//
//        Date expirationDate = jwtTokenProvider.getExpirationDate(token);
//        assertNotNull(expirationDate);
//        assertTrue(expirationDate.after(new Date()));
//    }
//
//    @Test
//    void testValidateToken() {
//        String username = "john_doe";
//        String roles = "ROLE_USER";
//
//        String token = jwtTokenProvider.createToken(username, roles);
//
//        User mockUser = new User();
//        mockUser.setUsername(username);
//
//        assertTrue(jwtTokenProvider.validateToken(token, mockUser));
//    }
//
//    @Test
//    void testTokenExpiration() throws InterruptedException {
////        jwtTokenProvider.jwtExpiration = 1000; // 1 секунда
//        String token = jwtTokenProvider.createToken("john_doe", "ROLE_USER");
//
//        // Ждем истечения срока действия токена
//        Thread.sleep(2000);
//
//        User mockUser = new User();
//        mockUser.setUsername("john_doe");
//
//        assertFalse(jwtTokenProvider.validateToken(token, mockUser));
//    }
//}
//
