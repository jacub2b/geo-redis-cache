package jack.awsome.config;

import jack.awsome.data.GeoObject;
import jack.awsome.logic.RandomNumberGenerator;
import org.redisson.Redisson;
import org.redisson.api.RGeo;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ServiceConfig {

    @Bean
    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator(10.00000, 50.0, new Random());
    }

    @Bean
    RGeo<GeoObject> redissonGeo() {
        return redissonClient().getGeo("geo");
    }

    private RedissonClient redissonClient() {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec()).useSingleServer().setAddress("redis://127.0.0.1:6379");

        return Redisson.create(config);
    }
}
