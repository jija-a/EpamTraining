package com.epam.task01.service.impl;

import com.epam.task01.domain.Point;
import com.epam.task01.service.PointService;

public class PointServiceImpl implements PointService {

    public static final PointService POINT_SERVICE = new PointServiceImpl();

    private PointServiceImpl() {
    }

    @Override
    public double findDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        double ac = Math.abs(firstPoint.getX() - secondPoint.getX());
        double cb = Math.abs(firstPoint.getY() - secondPoint.getY());

        return Math.hypot(ac, cb);
    }

    @Override
    public boolean isPointBelongsToLine(Point point, double m, double n) {
        return point.getX() >= m && point.getX() <= n;
    }

}
