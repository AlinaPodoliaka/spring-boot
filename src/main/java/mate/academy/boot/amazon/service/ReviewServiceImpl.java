package mate.academy.boot.amazon.service;

import mate.academy.boot.amazon.entity.Review;
import mate.academy.boot.amazon.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<String> findActiveUsers(Integer count) {
        return reviewRepository.findActiveUsers(count);
    }

    @Override
    public List<String> findMostCommentedGoods(Integer count) {
        return reviewRepository.findMostCommentedGoods(count);
    }
}
