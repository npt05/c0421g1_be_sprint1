package com.codegym.rest_controller;

import com.codegym.dto.AccountDto;
import com.codegym.jwtToken.JwtProvider;
import com.codegym.jwtToken.ResponseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@Valid @RequestBody AccountDto accountDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDto.getUsername(),accountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user =  userDetailsService.loadUserByUsername(accountDto.getUsername());
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority items: user.getAuthorities()){
            roles.add(items.getAuthority());
        }
        String token =  tokenProvider.generateToken(user);
        return new ResponseEntity<>( new ResponseToken(token, user.getUsername(), roles), HttpStatus.OK);
    }
}
