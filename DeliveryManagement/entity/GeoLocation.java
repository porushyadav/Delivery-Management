package DeliveryManagement.entity;


public class GeoLocation {
    private String name;
    private double latitude;
    private double longitude;

    public GeoLocation(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public  double calculateDistance(GeoLocation location) {
        double lat1 = Math.toRadians(latitude);
        double lon1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(location.getLatitude());
        double lon2 = Math.toRadians(location.getLongitude());

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of the earth in kilometers
        double r = 6371;

        // Calculate the distance
        return c * r;
    }
}