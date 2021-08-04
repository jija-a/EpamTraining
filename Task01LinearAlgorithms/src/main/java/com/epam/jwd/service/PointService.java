package com.epam.jwd.service;

import com.epam.jwd.domain.Point;

public interface PointService {

    double findDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint);

    boolean isPointBelongsToLine(Point point, double m, double n);

}
