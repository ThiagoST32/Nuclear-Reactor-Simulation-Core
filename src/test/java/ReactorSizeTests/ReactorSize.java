package ReactorSizeTests;


import Services.ReactorSizeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class ReactorSize {

    @Autowired
    private final ReactorSizeService reactorSizeService;

    public ReactorSize(ReactorSizeService reactorSizeService) {
        this.reactorSizeService = reactorSizeService;
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void deveCalcularCorretamenteDiametroDoCilindro(double s){
       double teste = reactorSizeService.diameterCalculateForCylindricalVases(s, s, s);
        Assertions.assertEquals(14000, teste);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(56.0),
                Arguments.of(28.0),
                Arguments.of(0.1)
        );
    }
}
