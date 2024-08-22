package form.responseoptions.domain.service;

import form.responseoptions.domain.entity.ResOption;

public interface ResOptionService {
    ResOption FindResOptionById(int id);
    void CreateResOption(ResOption resOption);
    void UpdateResOption(ResOption resOption);
    void DeleteResOption(int id);
}
