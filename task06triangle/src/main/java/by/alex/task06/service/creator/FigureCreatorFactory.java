package by.alex.task06.service.creator;

public class FigureCreatorFactory {

    public static final FigureCreatorFactory FACTORY = new FigureCreatorFactory();

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
