package form.subresponse_options.domain.service;

import form.subresponse_options.domain.entity.SubResOp;

public interface SubResOpService {
    SubResOp FindSubResOpById(int id);
    void CreateSubResOp(SubResOp subResOp);
    void UpdateSubResOp(SubResOp subResOp);
    void DeleteSubResOp(int id);
}
