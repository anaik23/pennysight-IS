package sjsu.edu.cs151.PennySight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjsu.edu.cs151.PennySight.model.User;
import sjsu.edu.cs151.PennySight.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) throws Exception {
        if (userRepository.getUserByUsername(username) == null) {
            throw new Exception("Not Found");
        } else {
            return userRepository.getUserByUsername(username);
        }
//        return userRepository.getUserByUsername(username);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/user/{username}")
    public String deleteUser(@PathVariable String username) {
        return userRepository.delete(username);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/user/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        return userRepository.update(username,user);
    }
}
