package Services;

import Repository.ReactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactorSizeService {

    @Autowired
    private ReactorRepository reactorRepository;

    private double aTension;


    public double diameterCalculateForCylindricalVases(double internPressure, double internRay, double wallThickness){
        try {
            if (internPressure != 0){
                if (internRay != 0){
                    if (wallThickness != 0){
                        aTension = (internPressure * internRay) / wallThickness;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return aTension;
    }

}
