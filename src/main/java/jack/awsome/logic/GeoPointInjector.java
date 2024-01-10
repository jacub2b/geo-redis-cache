package jack.awsome.logic;

import jack.awsome.data.GeoObject;
import jack.awsome.data.Type;
import org.redisson.api.GeoEntry;
import org.redisson.api.RGeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoPointInjector {
    private RGeo<?> rGeo;
    private RandomNumberGenerator randomGenerator;

    @Autowired
    public GeoPointInjector(RGeo<?> rGeo, RandomNumberGenerator randomGenerator) {
        this.rGeo = rGeo;
        this.randomGenerator = randomGenerator;
    }


    public void injectRandomPoint() {
        Double randLong = randomGenerator.generate();
        Double randLat = randomGenerator.generate();
        GeoObject geoObject = new GeoObject(Type.FIRST, "content", randLat);
        GeoEntry entry = new GeoEntry(randLong, randLat, geoObject);
        rGeo.add(entry);
        System.out.println(entry.getMember());
    }
}
