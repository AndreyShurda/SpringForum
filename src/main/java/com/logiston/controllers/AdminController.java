package com.logiston.controllers;


import com.logiston.entity.Role;
import com.logiston.entity.User;
import com.logiston.repository.RoleRepository;
import com.logiston.services.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    public String list(Model model) {
        Iterable<User> users = userService.listAllUsers();
        model.addAttribute("users", users);
        return "/user/users";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        model.addAttribute("roles", roleRepository.findAll());

        List<Role> collect = userById.getRoles().stream()
                .collect(Collectors.toList());

        Role currentRole = collect.get(0);
        model.addAttribute("currentRole", currentRole);


        return "/user/userEdit";
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.POST)
    public String saveProduct(HttpServletRequest request, @PathVariable Long id, User user) {
        Integer userRole = new Integer(request.getParameter("userRole"));

        Role role = roleRepository.findOne(userRole);

        User userById = userService.getUserById(id);
        userById.setName(user.getName());
        userById.setLastName(user.getLastName());
        userById.setEmail(user.getEmail());
        userById.setActive(user.getActive());
        userById.setRoles(new HashSet<Role>(Arrays.asList(role)));

        userService.saveEditUser(userById);

        return "redirect:/user/users";
    }
}
