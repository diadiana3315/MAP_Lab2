package domain;

public class AirTrafficControl {

    private static AirTrafficControl instance;

    private AirTrafficControl() {

    }

    public static AirTrafficControl getInstance() {
        if (instance == null)
            instance = new AirTrafficControl();
        return instance;
    }

}
