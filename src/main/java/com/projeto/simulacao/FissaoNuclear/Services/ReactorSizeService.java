package com.projeto.simulacao.FissaoNuclear.Services;

import com.projeto.simulacao.FissaoNuclear.Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactorSizeService {

    @Autowired
    private ReactorRepository reactorRepository;

    private static final String POSITIVE_NON_ZERO = "THE VALUES CANNOT BE ZERO!!!";
    private static final String NEGATIVE_NUMBER = "THE VALUE CANNOT BE NEGATIVE!!!";


    //Example of maximum endured stress constant
    private static final double MAX_CYLINDER_STAINLESS_STEEL_STRESS = 150;
    private static final double MAX_SPHERE_STAINLESS_STEEL_STRESS = 150;

    public void validatePositiveNonZero(double... values) {
        for (double value : values) {
            if (value == 0) {
                throw new IllegalArgumentException(POSITIVE_NON_ZERO);
            } else if (value < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER);
            }
        }
    }

    public double calculateCylinderStress(double internalOperatingPressure, double internRay, double wallThickness) {
        // internalOperatingPressure == MPA ----- internRay == 2 / internDiameter ----- wallThickness == value
        validatePositiveNonZero(internalOperatingPressure, internRay, wallThickness);
        return (internalOperatingPressure * internRay) / wallThickness;
    }

    public double calculateSphereStress(double internalOperatingPressure, double internRay, double wallThickness) {
        //internalOperatingPressure == MPA ----- internRay == 2 / internDiameter ----- wallThickness == value
        validatePositiveNonZero(internalOperatingPressure, internRay, wallThickness);
        return (internalOperatingPressure * internRay) / (2 * wallThickness);
    }

    public double calculateTankCapacity(double totalLitersTank, double productDensity) {
        //totalLitersTank == The total liter capacity chosen by user ----- productDensity == The density of the element required by user.
        validatePositiveNonZero(totalLitersTank, productDensity);
        return totalLitersTank * productDensity;
    }
}