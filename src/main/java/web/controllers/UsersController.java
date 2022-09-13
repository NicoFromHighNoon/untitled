package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("list", userService.listUsers());

        return "users";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "user";
    }

    @GetMapping("/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "add";
    }

    @PostMapping()
    public String userCreate(@ModelAttribute("user") User user) {
        userService.addUser(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));

        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.remove(id);

        return "redirect:/users";
    }
}