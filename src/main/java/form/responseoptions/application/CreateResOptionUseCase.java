package form.responseoptions.application;

import form.responseoptions.domain.entity.ResOption;
import form.responseoptions.domain.service.ResOptionService;

public class CreateResOptionUseCase {
    private final ResOptionService resOptionService;

    public CreateResOptionUseCase(ResOptionService resOptionService) {
        this.resOptionService = resOptionService;
    }

    public void execute(ResOption resOption) {
        resOptionService.CreateResOption(resOption);
    }
}
