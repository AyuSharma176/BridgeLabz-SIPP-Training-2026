class EarthVolume {

    public static void main(String[] args) {

        double radiusInKm = 6378;
        double pi = 3.14159265359;

        double volumeInKm =
                (4.0 / 3.0) * pi * radiusInKm * radiusInKm * radiusInKm;

        double volumeInMiles =
                volumeInKm / (1.6 * 1.6 * 1.6);

        System.out.println(
                "The volume of earth in cubic kilometers is " +
                volumeInKm +
                " and cubic miles is " +
                volumeInMiles
        );
    }
}