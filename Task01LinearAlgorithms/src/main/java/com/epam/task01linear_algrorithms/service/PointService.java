package com.epam.task01linear_algrorithms.service;

import com.epam.task01linear_algrorithms.domain.Point;

public interface PointService {

    double findDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint);

    boolean isPointBelongsToLine(Point point, double m, double n);

}
