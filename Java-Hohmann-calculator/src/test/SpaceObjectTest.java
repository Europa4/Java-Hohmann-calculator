package test;

import main.SpaceObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class SpaceObjectTest {

    public static List<SpaceObjectDistanceTestData> data() {
        SpaceObject HomeObject = new SpaceObject("Home Object", 3, 0, Math.PI/2);
        double littleDelta = 0.05;
        List<SpaceObjectDistanceTestData> testData = new ArrayList<>();
        testData.add(new SpaceObjectDistanceTestData("(3, 0, pi/2) -> (4, pi/2, pi/2) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, Math.PI/2, Math.PI/2), 25.0));
        testData.add(new SpaceObjectDistanceTestData("(3, 0, pi/2) -> (4, pi/2, pi/2) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, Math.PI/2, Math.PI/2), 25.0));
        testData.add(new SpaceObjectDistanceTestData("(3, 0, pi/2) -> (4, 3pi/2, pi/2) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, 3*Math.PI/2, Math.PI/2), 25.0));
        testData.add(new SpaceObjectDistanceTestData("(3, 0, pi/2) -> (4, 0, 0) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, 0, 0), 25.0));
        testData.add(new SpaceObjectDistanceTestData("(3, 0, pi/2) -> (4, 0, pi) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, 0, Math.PI), 25.0));
        HomeObject = new SpaceObject("Home Object", 3, 0, 0);
        testData.add(new SpaceObjectDistanceTestData("(3, 0, 0) -> (4, 0, pi) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, 0, Math.PI), 49.0));
        HomeObject = new SpaceObject("Home Object", 3, 0 + littleDelta, Math.PI/2);
        testData.add(new SpaceObjectDistanceTestData("(3, 0 + d, pi/2) -> (4, pi + d, pi/2) Distance between objects calculation test",
                HomeObject, new SpaceObject("Distant Object", 4, Math.PI + littleDelta, Math.PI/2), 49.0));
        return testData;
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void distanceSquaredTo(SpaceObjectDistanceTestData data) {
        SpaceObject HomeObject = data.CloseObject;
        SpaceObject DistantObject = data.DistantObject;
        assertEquals(data.ExpectedSquareDistance, HomeObject.distanceSquaredTo(DistantObject), 1E-6, data.NameForTest);
    }
}

class SpaceObjectDistanceTestData{
    double ExpectedSquareDistance;
    SpaceObject DistantObject;
    SpaceObject CloseObject;
    String NameForTest;

    public SpaceObjectDistanceTestData(String nameForTest, SpaceObject closeObject, SpaceObject distantObject, double expectedSquareDistance){
        NameForTest = nameForTest;
        CloseObject = closeObject;
        DistantObject = distantObject;
        ExpectedSquareDistance = expectedSquareDistance;
    }
}