//package com.mainul35.bsuserinfo.initialize;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.traver.authserver.models.RoleModel;
//import com.traver.authserver.models.UserModel;
//import com.traver.authserver.repositories.RoleRepository;
//import com.traver.authserver.repositories.UserRepository;
//import com.traver.authserver.services.TokenService;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Profile("prod")
//@Component
//public class InitializeProdData implements InitializeData {
//
//    private final UserRepository userRepository;
//
//    private final RoleRepository roleRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final TokenService tokenService;
//
//    private final ResourceLoader resourceLoader;
//
//    public InitializeProdData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, TokenService tokenService, ResourceLoader resourceLoader) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.tokenService = tokenService;
//        this.resourceLoader = resourceLoader;
//    }
//
//    @Override
//    public void initialize() {
//        addRoles ();
//        addUsers ();
//    }
//
//    private void addUsers() {
//        try {
//            List<UserModel> UserModels = new ObjectMapper ()
//                    .readValue (
//                            resourceLoader.getResource ("classpath:users.json").getInputStream (),
//                            new TypeReference<ArrayList<UserModel>> () {
//                            }
//                    );
//            UserModels.forEach (UserModel -> {
//                boolean found = userRepository
//                        .findByUsernameOrEmail (UserModel.getUsername (), UserModel.getEmail ())
//                        .size () > 0;
//                if (!found) {
//                    tokenService.generateToken (UserModel);
//                    UserModel.setPassword (passwordEncoder.encode (UserModel.getPassword ()));
//                    userRepository.saveAndFlush (UserModel);
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
//    }
//
//    private void addRoles() {
//        try {
//            List<RoleModel> RoleModels = new ObjectMapper ()
//                    .readValue (
//                            resourceLoader.getResource ("classpath:roles.json").getInputStream (),
//                            new TypeReference<ArrayList<RoleModel>> () {
//                            }
//                    );
//            RoleModels.forEach (RoleModel -> {
//                if (!roleRepository.findByRole (RoleModel.getRole ()).isPresent ()) {
//                    roleRepository.saveAndFlush (RoleModel);
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
//    }
//}
