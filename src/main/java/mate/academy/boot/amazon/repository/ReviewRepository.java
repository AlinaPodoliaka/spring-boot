package mate.academy.boot.amazon.repository;

import mate.academy.boot.amazon.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {

    @Query(value = "SELECT profile_name FROM REVIEWS group by profile_name " +
            "order by count(profile_name) desc limit ?1", nativeQuery = true)
    public List<String> findActiveUsers(Integer count);

    @Query(value = "SELECT product_id FROM REVIEWS group by product_id " +
            "order by count(product_id) desc limit ?1", nativeQuery = true)
    public List<String> findMostCommentedGoods(Integer count);
}
