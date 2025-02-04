package Services;

import Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactorSizeService {

    @Autowired
    private ReactorRepository reactorRepository;

    public double calculateCylinderDiameter(double internPressure, double internRay, double wallThickness) {
        double tensionInCylinder;
        try {
            if (internPressure != 0 && internRay != 0) {
                if (internPressure > 0 && internRay > 0) {
                    tensionInCylinder = (internPressure * internRay) / wallThickness;
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

    public double calculateSpheresDiameter(double internPressure, double internRay, double wallThickness) {
        double tensionInSpheres;
        try {
            if (internPressure != 0 && internRay != 0) {
                if (internPressure > 0 && internRay > 0) {
                    tensionInSpheres = (internPressure * internRay) / (2 * wallThickness);
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
}
