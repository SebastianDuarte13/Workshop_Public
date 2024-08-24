package capitulouno.sobreti.application;

import capitulouno.sobreti.domain.entity.Sobreti;
import capitulouno.sobreti.domain.service.SobretiService;

public class CreateSobretiUseCase {
    private final SobretiService sobretiService;

    public CreateSobretiUseCase(SobretiService sobretiService) {
        this.sobretiService = sobretiService;
    }

    public void execute(Sobreti sobreti) {
        sobretiService.CreateSobreti(sobreti);
    }
}
