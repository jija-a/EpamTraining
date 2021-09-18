package by.alex.task06.service.creator;

public final class FigureCreatorFactory {

    private FigureCreatorFactory() {
    }

    public static PointCreator getPointCreator() {
        return PointCreator.CREATOR;
    }

    public static TriangleCreator getTriangleCreator() {
        return TriangleCreator.CREATOR;
    }

    public static CircleCreator getCircleCreator() {
        return CircleCreator.CREATOR;
    }


}
