package ReactorSizeTests;


import Services.ReactorSizeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReactorSize {

    private ReactorSizeService reactorSizeService;

    @BeforeEach
    public void setUp(){
        reactorSizeService = new ReactorSizeService();
    }

    @Test
    public void deveCalcularCorretamenteDiametroDoCilindro(){
       double teste = reactorSizeService.calculateCylinderDiameter(48, 24 ,0.1);
        Assertions.assertEquals(14000, teste);
    }

    @Test
    public void deveCalcularCorretamenteDiametroDeEsferios(){
        double teste = reactorSizeService.calculateSpheresDiameter(-1, 24, 0.1);
        Assertions.assertEquals(5760, teste);
    }

}
