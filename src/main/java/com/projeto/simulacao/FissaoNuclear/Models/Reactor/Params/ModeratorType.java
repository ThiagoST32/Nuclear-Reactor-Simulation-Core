package com.projeto.simulacao.FissaoNuclear.Models.Reactor.Params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeratorType {

    private String moderatorType;

    public ModeratorType(String moderatorType){
        this.verifyIfModeratorTypeIsCompatible(moderatorType);
        this.setModeratorType(moderatorType);
    }

    private void verifyIfModeratorTypeIsCompatible(String moderatorType) {
        if (!moderatorType.isEmpty()){
            throw new RuntimeException("This moderator type is not compatible with reactor type!");
        }
    }
}
