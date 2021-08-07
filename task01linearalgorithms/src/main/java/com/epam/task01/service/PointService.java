package com.epam.task01.service;

import com.epam.task01.domain.Point;

public interface PointService {

    double findDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint);

    boolean isPointBelongsToLine(Point point, double m, double n);

}
