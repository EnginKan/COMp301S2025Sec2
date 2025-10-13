package com.yeditepe.firstapp.controller;


import com.yeditepe.firstapp.controller.dto.userDTO;
import com.yeditepe.firstapp.entity.User;
import com.yeditepe.firstapp.modelmapper.UserMapper;
import com.yeditepe.firstapp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    List<userDTO> users = new ArrayList<>(
            Arrays.asList(new userDTO("Ahmet","ahmet@gmail.com"),
                    new userDTO("Ayse","ayse@gmail.com"))
    );

    UserRepository userRepository;
    // must be defined in order get userRepository instance(Bean)
    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path= "/greeting",method = RequestMethod.GET)
    public String welcome(){
        return "Hello World!";
    }

    @GetMapping(path= "/greeting/{name}")
    public String greeting(@PathVariable(name="name") String username){
        return "Hello "+username+"!";
    }

    @GetMapping(path = "/searchuserbyname/{name}")
    public List<userDTO> searchUserByName(@PathVariable(name="name") String username){
        List<userDTO> filtered=
                users.stream().filter(userDTO -> userDTO.getUsername().equals(username)).
                        collect(Collectors.toList());
        System.out.println(users);

        return filtered;
    }

    @GetMapping("search")
    public ResponseEntity<List<userDTO>> search(@RequestParam(name="name",required = false,defaultValue = "None") String name,
                                                @RequestParam(name="email",required = false,defaultValue = "None") String email){

//        List<userDTO> filtered=users.stream().
//                filter(u->(u.getUsername().equals(name) ||  u.getEmail().equals(email))).
//                collect(Collectors.toList());
       List<User> filtered= new ArrayList<>() ;
       if(name!=null && email!=null){
           filtered= (List<User>) userRepository.findUserByNameAndEmail(name, email);
       }
        if(filtered.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            ArrayList<userDTO> filtered_users = (ArrayList<userDTO>) filtered.stream().map(user -> UserMapper.toUserDTO(user)).collect(Collectors.toList());
            return ResponseEntity.ok(filtered_users);
        }
    }
    @PostMapping("/createuser")
        public ResponseEntity<String> createuser(@RequestBody userDTO user){
        userRepository.save(new User(user.getUsername(),user.getEmail()));
        return ResponseEntity.ok("new user is created");
        }
}
