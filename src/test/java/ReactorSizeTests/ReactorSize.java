package ReactorSizeTests;


import com.projeto.simulacao.FissaoNuclear.Services.ReactorSizeService;
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
       double teste = reactorSizeService.calculateCylinderStress(10, 0.11 ,0.01);
        Assertions.assertEquals(110, teste);
        System.out.println(teste);
    }

    @Test
    public void deveCalcularCorretamenteDiametroDeEsferios(){
        double teste = reactorSizeService.calculateSphereStress(10, 0.11, 0.01);
        Assertions.assertEquals(55, teste);
        System.out.println(teste);
    }

    @Test
    public void deveCalcularCapacidadeDoTanqueEmKilos(){
        double teste = reactorSizeService.calculateTankCapacity(100, 0.76);
        System.out.println(teste);
        Assertions.assertEquals(76, teste);
    }

}
