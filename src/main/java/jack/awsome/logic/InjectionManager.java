package jack.awsome.logic;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class InjectionManager {
    private GeoPointInjector geoPointInjector;

    public InjectionManager(GeoPointInjector geoPointInjector) {
        this.geoPointInjector = geoPointInjector;
    }

    @Scheduled(fixedDelayString = "10")
    public void inject() {
        geoPointInjector.injectRandomPoint();
    }
}
