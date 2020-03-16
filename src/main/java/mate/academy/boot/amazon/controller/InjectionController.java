package mate.academy.boot.amazon.controller;

import mate.academy.boot.amazon.entity.Review;
import mate.academy.boot.amazon.service.ReviewService;
import mate.academy.boot.amazon.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Controller
public class InjectionController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private Parser customCSVParser;

    @PostConstruct
    public void init() {
        try {
            long startReading = System.currentTimeMillis();
            List<Review> reviews = customCSVParser.parseCSVFile("Reviews.csv");
            long startSaving = System.currentTimeMillis();
            reviewService.saveAll(reviews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
