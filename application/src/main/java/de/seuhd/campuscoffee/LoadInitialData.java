package de.seuhd.campuscoffee;

import de.seuhd.campuscoffee.domain.model.objects.Pos;
import de.seuhd.campuscoffee.domain.model.objects.Review;
import de.seuhd.campuscoffee.domain.model.objects.User;
import de.seuhd.campuscoffee.domain.ports.api.UserService;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;
import de.seuhd.campuscoffee.domain.ports.api.PosService;
import de.seuhd.campuscoffee.domain.ports.api.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Component that loads initial data into the application when running in the "dev" profile.
 */
@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
class LoadInitialData implements InitializingBean {
    private final PosService posService;
    private final UserService userService;
    private final ReviewService reviewService;


    @Override
    public void afterPropertiesSet() {
        log.info("Deleting existing data...");
        reviewService.clear();
        posService.clear();
        userService.clear();
        log.info("Loading initial data...");
        List<User> userFixtures = TestFixtures.createUserFixtures(userService);
        log.info("Created {} users.", userFixtures.size());
        List<Pos> posFixtures = TestFixtures.createPosFixtures(posService);
        log.info("Created {} POS.", posFixtures.size());
        List<Review> reviewFixtures = TestFixtures.createReviewFixtures(reviewService);
        log.info("Created {} reviews.", reviewFixtures.size());
        log.info("Initial data loaded successfully.");
    }
}