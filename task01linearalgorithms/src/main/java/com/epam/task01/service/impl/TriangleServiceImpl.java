package com.epam.task01.service.impl;

import com.epam.task01.domain.Triangle;
import com.epam.task01.service.TriangleService;

public class TriangleServiceImpl implements TriangleService {

    public static final TriangleService TRIANGLE_SERVICE = new TriangleServiceImpl();

    private TriangleServiceImpl() {
    }

    @Override
    public boolean triangleIsIsosceles(Triangle triangle) {
        return (triangle.getA() == triangle.getB() && triangle.getA() != triangle.getC())
                || (triangle.getA() == triangle.getC() && triangle.getA() != triangle.getB())
                || (triangle.getB() == triangle.getC() && triangle.getB() != triangle.getA());
    }

}
