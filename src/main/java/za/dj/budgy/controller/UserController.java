package za.dj.budgy.controller;

import org.springframework.web.bind.annotation.*;
import za.dj.budgy.model.AppUser;
import za.dj.budgy.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<AppUser> getAll(){
        return this.userService.getAll();
    }

    @PostMapping
    private void createUser(@RequestBody AppUser appUser){
        this.userService.create(appUser);
    }
}
