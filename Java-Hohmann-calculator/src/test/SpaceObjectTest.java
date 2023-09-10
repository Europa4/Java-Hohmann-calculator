import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceObjectTest {

    public static SpaceObjectDistanceTestData[] data() {
        SpaceObjectDistanceTestData[] testData = new SpaceObjectDistanceTestData[1];
        testData[0] = (new SpaceObjectDistanceTestData("Phi = pi/2, theta = pi/2 Distance between objects calculation test",
                new SpaceObject("Distant Object", 4, Math.PI/2, Math.PI/2), 25.0));
        return testData;
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void distanceSquaredTo(SpaceObjectDistanceTestData data) {
        SpaceObject HomeObject = new SpaceObject("Home Object", 3, 0, Math.PI/2);
        SpaceObject DistantObject = data.TestObject;
        assertEquals(data.ExpectedSquareDistance, HomeObject.distanceSquaredTo(DistantObject), data.NameForTest);
    }
}

class SpaceObjectDistanceTestData{
    double ExpectedSquareDistance;
    SpaceObject TestObject;
    String NameForTest;

    public SpaceObjectDistanceTestData(String nameForTest, SpaceObject testObject, double expectedSquareDistance){
        NameForTest = nameForTest;
        TestObject = testObject;
        ExpectedSquareDistance = expectedSquareDistance;
    }
}