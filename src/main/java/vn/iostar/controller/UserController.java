package vn.iostar.controller;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iostar.entity.User;
import vn.iostar.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping("")
    public String list(ModelMap model,
                       @RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       @RequestParam(required=false) String q) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<User> pg = service.search(q, pageable);
        model.addAttribute("users", pg.getContent());
        model.addAttribute("page", pg);
        model.addAttribute("q", q);
        return "admin/accounts/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("user", new User());
        return "admin/accounts/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Integer id) {
        model.addAttribute("user", service.findById(id).orElse(new User()));
        return "admin/accounts/add";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(ModelMap model, @ModelAttribute("user") User u) {
        service.save(u);
        model.addAttribute("message","Saved!");
        return new ModelAndView("redirect:/admin/users", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable Integer id) {
        service.deleteById(id);
        model.addAttribute("message","Deleted!");
        return new ModelAndView("redirect:/admin/users", model);
    }
}
