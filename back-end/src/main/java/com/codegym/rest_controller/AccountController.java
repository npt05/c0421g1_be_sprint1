package com.codegym.rest_controller;

import com.codegym.dto.AccountDto;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_account.AccountDetails;
import com.codegym.jwtToken.JwtProvider;
import com.codegym.jwtToken.ResponseToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/public")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider tokenProvider;

    @GetMapping("/info")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    //    Kiet login API use to authentication by HttpBasic 23/10
    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDto.getUsername(), accountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user = userDetailsService.loadUserByUsername(accountDto.getUsername());
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority items : user.getAuthorities()) {
            roles.add(items.getAuthority());
        }
        String token = tokenProvider.generateToken(user);
        return new ResponseEntity<>(new ResponseToken(token, user.getUsername(), roles), HttpStatus.OK);
    }

//    Kiet login API use to refreshToken 23/10
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization != null && authorization.startsWith("KIET ")) {
            try {
                authorization = authorization.substring(5);
                String username = tokenProvider.getUsernameFromToken(authorization);
                AccountDetails account = (AccountDetails) userDetailsService.loadUserByUsername(username);
                String token = tokenProvider.generateToken(account);
                Map<String, String> tokenResponse = new HashMap<>();
                tokenResponse.put("refreshToken", token);
                new ObjectMapper().writeValue(response.getOutputStream(), tokenResponse);
            } catch (Exception ex) {
                System.out.println("Message log{}" + ex.getMessage());
            }
        }
    }
}

