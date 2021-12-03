package sjsu.edu.cs151.PennySight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjsu.edu.cs151.PennySight.model.User;
import sjsu.edu.cs151.PennySight.repository.UserRepository;

/**
 * This is the REST controller class for the user
 * Annotated with @RestController indicates this class is a REST controller
 * RestController means @Controller + @ResponseBody
 * Inject the User Repository by using @Autowired
 * This class contains four API method, which corresponding to the four CRUD operations in the Repository class
 * author PennySight
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * This method is the PUT method to save users into database
     * @param user
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * This method is the GET method to get users from database
     * @param username
     * @return
     * @throws Exception
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) throws Exception {
        if (userRepository.getUserByUsername(username) == null) {
            throw new Exception("Not Found");
        } else {
            return userRepository.getUserByUsername(username);
        }
    }

    /**
     * This method is the DELETE method to delete users from database
     * @param username
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/user/{username}")
    public String deleteUser(@PathVariable String username) {
        return userRepository.delete(username);
    }

    /**
     * This method is the UPDATE method to update users from database
     * @param username
     * @param user
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/user/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        return userRepository.update(username,user);
    }
}
