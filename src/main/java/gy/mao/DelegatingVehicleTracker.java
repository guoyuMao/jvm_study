package gy.mao;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by guoyu.mao on 2019/7/3.
 * Email:maoguoyu@ewell.cc
 */
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(ConcurrentMap<String, Point> locations, Map<String, Point> unmodifiableMap) {
        this.locations = locations;
        this.unmodifiableMap = unmodifiableMap;
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocations(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name :" + id);
        }
    }
}
