package com.projeto.simulacao.FissaoNuclear.Services;

import com.projeto.simulacao.FissaoNuclear.Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactorSizeService {

    @Autowired
    private ReactorRepository reactorRepository;

    public double calculateCylinderDiameter(double internalOperatingPressure, double internRay, double wallThickness) {

        /*
            internalOperatingPressure == MPA
            internRay == 2 / internDiameter
            wallThickness == value
         */

        double tensionInCylinder;
        try {
            if (internalOperatingPressure != 0 && internRay != 0) {
                if (internalOperatingPressure > 0 && internRay > 0) {
                    tensionInCylinder = (internalOperatingPressure * internRay) / wallThickness;
                } else {
                    throw new IllegalArgumentException("The values cannot be negative!!");
                }
            } else {
                throw new IllegalArgumentException("The values cannot be zero!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tensionInCylinder;
    }

    public double calculateSpheresDiameter(double internalOperatingPressure, double internRay, double wallThickness) {

        /*
            internalOperatingPressure == MPA
            internRay == 2 / internDiameter
            wallThickness == value
         */

        double tensionInSpheres;
        try {
            if (internalOperatingPressure != 0 && internRay != 0) {
                if (internalOperatingPressure > 0 && internRay > 0) {
                    tensionInSpheres = (internalOperatingPressure * internRay) / (2 * wallThickness);
                } else {
                    throw new IllegalArgumentException("The values cannot be negative!!");
                }
            } else {
                throw new IllegalArgumentException("The values cannot be zero!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tensionInSpheres;
    }

    public double calculateTankCapacityPerKilo(double totalLitersTank, double productDensity) {
        /*
            totalLitersTank == The total liter capacity chosen by user.
            productDensity == The density of the element required by user.
         */
        double totalKilo;
        try {
            if (totalLitersTank != 0 && productDensity != 0) {
                if (totalLitersTank > 0 && productDensity > 0) {
                    totalKilo = totalLitersTank * productDensity;
                } else {
                    throw new IllegalArgumentException("The values cannot be negative!!");
                }
            } else {
                throw new IllegalArgumentException("The values cannot be zero!!");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return totalKilo;
    }
}
