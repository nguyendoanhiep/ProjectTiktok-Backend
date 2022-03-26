package com.codegym.tiktok.securityPackage.controller;
import com.codegym.tiktok.securityPackage.dto.request.ChangeAvatar;
import com.codegym.tiktok.securityPackage.dto.request.LoginForm;
import com.codegym.tiktok.securityPackage.dto.request.RegisterForm;
import com.codegym.tiktok.securityPackage.dto.response.JwtResponse;
import com.codegym.tiktok.securityPackage.dto.response.ResponseMessage;
import com.codegym.tiktok.securityPackage.model.Role;
import com.codegym.tiktok.securityPackage.model.RoleName;
import com.codegym.tiktok.securityPackage.security.jwt.JwtProvider;
import com.codegym.tiktok.securityPackage.security.jwt.JwtTokenFilter;
import com.codegym.tiktok.securityPackage.security.userpincal.UserPrinciple;
import com.codegym.tiktok.securityPackage.service.IRegistrationService;
import com.codegym.tiktok.securityPackage.service.IRoleService;
import com.codegym.tiktok.securityPackage.service.IUserService;
import com.codegym.tiktok.userPackage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    JwtTokenFilter jwtTokenFilter;
    @Autowired
    IRegistrationService registrationService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterForm registerForm) {
        if (userService.existsByUsername(registerForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("no_user"), HttpStatus.OK);
        }
        if (userService.existsByEmail(registerForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("no_email"), HttpStatus.OK);
        }
        if (registerForm.getAvatar() == null || registerForm.getAvatar().trim().isEmpty()) {
            registerForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/chinhbeo-18d3b.appspot.com/o/avatar.png?alt=media&token=3511cf81-8df2-4483-82a8-17becfd03211");
        }
        User user = new User(registerForm.getName(), registerForm.getUsername(), registerForm.getEmail(), registerForm.getAvatar(), passwordEncoder.encode(registerForm.getPassword()));
        Set<String> strRoles = registerForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "user":
                    Role adminRole = roleService.findByName(RoleName.USER).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        registrationService.register(user);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginForm loginForm) {
        User user = userService.findByUsername(loginForm.getUsername()).get();
        if(user.getStatus()!=3){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        User user1 = userService.findByUsername(userPrinciple.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(token, user1));}
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/change-avatar")
    public ResponseEntity<?> changeAvatar(HttpServletRequest request, @Valid @RequestBody ChangeAvatar changeAvatar) {
        String jwt = jwtTokenFilter.getJwt(request);
        String username = jwtProvider.getUserNameFromToken(jwt);
        User user;
        try {
            if (changeAvatar.getAvatar() == null) {
                return new ResponseEntity<>(new ResponseMessage("no"), HttpStatus.OK);
            } else {
                user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found -> username" + username));
                user.setAvatar(changeAvatar.getAvatar());
                userService.save(user);
            }
            return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
        } catch (UsernameNotFoundException exception) {
            return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
