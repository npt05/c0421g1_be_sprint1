package com.codegym.rest_controller;

import com.codegym.dto.AccountDto;
import com.codegym.entity.about_account.AccountDetails;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> loginWithUsernamePassword( @RequestBody AccountDto accountDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDto.getUsername(),accountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountDetails account = (AccountDetails) userDetailsService.loadUserByUsername(accountDto.getUsername());
        String token = tokenProvider.generateToken(account);
        List<String> getRoles = new ArrayList<>();
        for (GrantedAuthority items: account.getAuthorities()) {
            getRoles.add(items.getAuthority());
        }
       return new ResponseEntity<>(new ResponseToken(token, account.getUsername(), getRoles),HttpStatus.OK);
        }


    }

