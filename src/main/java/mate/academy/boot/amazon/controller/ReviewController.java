package mate.academy.boot.amazon.controller;

import mate.academy.boot.amazon.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/users")
    public List<String> getMostActiveUsers() {
        return reviewService.findActiveUsers(1000);
    }

    @GetMapping("/goods")
    public List<String> getMostCommentedGoods() {
        return reviewService.findMostCommentedGoods(1000);
    }
}
