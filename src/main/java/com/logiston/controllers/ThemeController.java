package com.logiston.controllers;

import com.logiston.entity.Comment;
import com.logiston.entity.Theme;
import com.logiston.entity.User;
import com.logiston.services.ThemeService;
import com.logiston.services.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/themes", method = RequestMethod.GET)
    public String list(Model model) {
        Iterable<Theme> themes = themeService.listAllThemes();
        model.addAttribute("themes", themes);
        return "themes";
    }

    @RequestMapping("theme/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("theme", themeService.getThemeById(id));
        Comment comment = new Comment();
        model.addAttribute("comment", comment);

        return "themeshow";
    }

    @RequestMapping("theme/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("theme", themeService.getThemeById(id));
        return "themeEdit";
    }

    @RequestMapping("theme/delete/{id}")
    public String delete(@PathVariable Long id) {
        System.out.println(id);
        themeService.delete(id);
        return "redirect:/themes";
    }

    @RequestMapping("theme/new")
    public String newProduct(Model model) {
        Theme theme = new Theme();
        model.addAttribute("theme", theme);

        return "themeform";
    }


    @RequestMapping(value = "theme", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Theme theme) {
        String message = request.getParameter("message");
        if (theme.getThemeId() == null) {
            Comment comment = new Comment();
            comment.setMessage(message);
            comment.setDateTime(LocalDateTime.now());

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            comment.setUser(user);
            theme.getComments().add(comment);

            themeService.saveTheme(theme);
        } else {
            Theme themeById = themeService.getThemeById(theme.getThemeId());
            themeById.setTitle(theme.getTitle());

            themeService.saveTheme(themeById);
        }

        return "redirect:/themes";
    }

    @RequestMapping(value = "theme/{id}", method = RequestMethod.POST)
    public String saveProduct(@PathVariable Long id, Comment comment) {
        Theme themeById = themeService.getThemeById(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        comment.setUser(user);
        comment.setDateTime(LocalDateTime.now());
        themeById.getComments().add(comment);
        themeService.saveTheme(themeById);

        return "redirect:/theme/" + id;
    }

}
