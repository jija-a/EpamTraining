package com.epam.task01linear_algrorithms.service.impl;

import com.epam.task01linear_algrorithms.domain.Point;
import com.epam.task01linear_algrorithms.service.PointService;

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
