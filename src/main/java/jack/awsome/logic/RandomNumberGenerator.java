package jack.awsome.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

public class RandomNumberGenerator {
    private Double min;
    private Double max;
    private Random random;

    public RandomNumberGenerator(Double min, Double max, Random random) {
        this.min = min;
        this.max = max;
        this.random = random;
    }

    public Double generate() {
        return random.nextDouble(min, max);
    }
}
