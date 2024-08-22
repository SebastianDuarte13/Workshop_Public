package form.subresponse_options.application;

import form.subresponse_options.domain.entity.SubResOp;
import form.subresponse_options.domain.service.SubResOpService;

public class CreateSubResOpUseCase {
    private final SubResOpService subResOpService;

    public CreateSubResOpUseCase(SubResOpService subResOpService) {
        this.subResOpService = subResOpService;
    }

    public void execute(SubResOp subResOp) {
        subResOpService.CreateSubResOp(subResOp);
    }
}
