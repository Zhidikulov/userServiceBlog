//package com.example.userServiceBlog;
//
//import com.example.userServiceBlog.config.JwtTokenFilter;
//import com.example.userServiceBlog.config.JwtTokenProvider;
//import com.example.userServiceBlog.modelDB.User;
//import com.example.userServiceBlog.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.mock.web.MockFilterChain;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.io.IOException;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class JwtTokenFilterTest {
//
//    private JwtTokenProvider jwtTokenProvider;
//    private UserRepository userRepository;
//    private JwtTokenFilter jwtTokenFilter;
//
//    @BeforeEach
//    void setUp() {
//        jwtTokenProvider = Mockito.mock(JwtTokenProvider.class);
//        userRepository = Mockito.mock(UserRepository.class);
////        jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider, userRepository);
//    }
//
//    @Test
//    void testDoFilterInternal_ValidToken() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.addHeader("Authorization", "Bearer validToken");
//
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
//
//        User mockUser = new User();
//        mockUser.setUsername("john_doe");
//
//        when(jwtTokenProvider.getUsername("validToken")).thenReturn("john_doe");
////        when(userRepository.findByUsername("john_doe")).thenReturn(Optional.of(mockUser));
//        when(jwtTokenProvider.validateToken("validToken", mockUser)).thenReturn(true);
//
////        jwtTokenFilter.doFilterInternal(request, response, filterChain);
//
//        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
//        assertEquals("john_doe", SecurityContextHolder.getContext().getAuthentication().getName());
//    }
//
//    @Test
//    void testDoFilterInternal_InvalidToken() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.addHeader("Authorization", "Bearer invalidToken");
//
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
//
//        when(jwtTokenProvider.getUsername("invalidToken")).thenThrow(new IllegalArgumentException("Invalid token"));
//
////        jwtTokenFilter.doFilterInternal(request, response, filterChain);
//
//        assertNull(SecurityContextHolder.getContext().getAuthentication());
//    }
//
//    @Test
//    void testDoFilterInternal_NoToken() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
//
////        jwtTokenFilter.doFilterInternal(request, response, filterChain);
//
//        assertNull(SecurityContextHolder.getContext().getAuthentication());
//    }
//}
//
