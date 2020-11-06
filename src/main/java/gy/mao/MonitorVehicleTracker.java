package gy.mao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoyu.mao on 2019/7/3.
 * Email:maoguoyu@ewell.cc
 */
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocations(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }


    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> mutablePointMap) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : mutablePointMap.keySet()) {
            result.put(id, new MutablePoint(mutablePointMap.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }


}
