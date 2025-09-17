package vn.iostar.controller;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iostar.entity.Category;
import vn.iostar.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private final CategoryService service;   

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("")
    public String list(ModelMap model,
                       @RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       @RequestParam(required=false) String name) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Category> pg = service.search(name, pageable);
        model.addAttribute("categories", pg.getContent());
        model.addAttribute("page", pg);
        model.addAttribute("name", name);
        return "admin/categories/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("category", new Category());
        return "admin/categories/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Integer id) {
        model.addAttribute("category", service.findById(id).orElse(new Category()));
        return "admin/categories/add";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(ModelMap model, @ModelAttribute("category") Category c) {
        service.save(c);
        model.addAttribute("message", "Saved!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable Integer id) {
        service.deleteById(id);
        model.addAttribute("message", "Deleted!");
        return new ModelAndView("redirect:/admin/categories", model);
    }
}
