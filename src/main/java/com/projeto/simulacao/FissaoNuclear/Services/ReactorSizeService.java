package com.projeto.simulacao.FissaoNuclear.Services;

import com.projeto.simulacao.FissaoNuclear.Infra.Exceptions.PositveNonZeroOrNegativeException;
import com.projeto.simulacao.FissaoNuclear.Models.Reactor;
import com.projeto.simulacao.FissaoNuclear.Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactorSizeService {

    @Autowired
    private ReactorRepository reactorRepository;

    //Example of maximum endured stress constant
    private static final double MAX_CYLINDER_STAINLESS_STEEL_STRESS = 150;
    private static final double MAX_SPHERE_STAINLESS_STEEL_STRESS = 150;

    private static final double MAX_CYLINDER_STAINLESS_ZIRCALOY_STRESS = 550;
    private static final double MAX_SPHERE_STAINLESS_ZIRCALOY_STRESS = 550;

    public void validatePositiveNonZero(double... values) {
        for (double value : values) {
            if (value <= 0) {
                throw new PositveNonZeroOrNegativeException();
            }
        }
    }

//    private void materialUsed(){
//        if (reactor.ge)
//    }

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