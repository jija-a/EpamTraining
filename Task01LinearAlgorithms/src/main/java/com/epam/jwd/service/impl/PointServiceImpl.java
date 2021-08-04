package com.epam.jwd.service.impl;

import com.epam.jwd.domain.Point;
import com.epam.jwd.service.PointService;

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

}
