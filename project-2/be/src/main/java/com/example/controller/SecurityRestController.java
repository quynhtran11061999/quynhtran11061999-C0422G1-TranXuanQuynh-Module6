package com.example.controller;

import com.example.jwt.JwtUtility;
import com.example.model.AppUser;
import com.example.model.LoginRequest;
import com.example.model.LoginResponse;
import com.example.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Optional<LoginRequest> loginRequest) {

        if (!loginRequest.isPresent()) {
            return new ResponseEntity<>("Không được để trống tài khoản, mật khẩu", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.get().getUsername(), loginRequest.get().getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetailService = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        List<String> roles = userDetailService.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String jwt = jwtUtility.generateJwtToken(loginRequest.get().getUsername());
        return new ResponseEntity<>(new LoginResponse(jwt, roles, loginRequest.get().getUsername()), HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> getResetEmail(@RequestBody Optional<String> email) {

        if (!email.isPresent()) {
            return new ResponseEntity<>("Không được để trống email", HttpStatus.BAD_REQUEST);
        }

        AppUser user = this.appUserService.findByEmail(email.get());
        if (user == null) {
            return new ResponseEntity<>("Email chưa được đăng ký", HttpStatus.BAD_REQUEST);
        }
        String jwt = jwtUtility.generateJwtToken(user.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
