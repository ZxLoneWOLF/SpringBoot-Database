package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.RoleRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HelloController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public HelloController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // CREATE USER
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setEnabled(updatedUser.isEnabled());

        return userRepository.save(user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted";
    }

    // CREATE ROLE
    @PostMapping("/roles")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // GET ROLES
    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    // ASSIGN ROLE
    @PostMapping("/{userId}/assign-role/{roleId}")
    public User assignRole(@PathVariable Long userId, @PathVariable Long roleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // 🔥 roles list already initialized in User.java → no null check needed
        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
        }

        return userRepository.save(user);
    }
}