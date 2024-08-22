package form.chapter.domain.service;

import form.chapter.domain.entity.Chapter;

public interface ChapterService {
    Chapter FindChapterById(int id);
    void CreateChapter(Chapter chapter);
    void UpdateChapter(Chapter chapter);
    void DeleteChapter(int id);
}
