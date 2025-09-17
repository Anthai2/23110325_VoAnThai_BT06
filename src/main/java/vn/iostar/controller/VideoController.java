package vn.iostar.controller;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iostar.entity.Video;
import vn.iostar.service.VideoService;
import vn.iostar.service.CategoryService;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {

    private final VideoService videoService;
    private final CategoryService categoryService;

    public VideoController(VideoService videoService, CategoryService categoryService) {
        this.videoService = videoService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String list(ModelMap model,
                       @RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       @RequestParam(required=false) String q) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Video> pg = videoService.search(q, pageable);
        model.addAttribute("videos", pg.getContent());
        model.addAttribute("page", pg);
        model.addAttribute("q", q);
        return "admin/products/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/products/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Integer id) {
        model.addAttribute("video", videoService.findById(id).orElse(new Video()));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/products/add";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(ModelMap model, @ModelAttribute("video") Video v) {
        videoService.save(v);
        model.addAttribute("message","Saved!");
        return new ModelAndView("redirect:/admin/videos", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable Integer id) {
        videoService.deleteById(id);
        model.addAttribute("message","Deleted!");
        return new ModelAndView("redirect:/admin/videos", model);
    }
}
