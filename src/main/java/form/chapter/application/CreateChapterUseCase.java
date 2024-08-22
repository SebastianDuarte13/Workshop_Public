package form.chapter.application;

import form.chapter.domain.entity.Chapter;
import form.chapter.domain.service.ChapterService;

public class CreateChapterUseCase {
    private final ChapterService chapterService;

    public CreateChapterUseCase(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    public void execute(Chapter chapter) {
        chapterService.CreateChapter(chapter);
    }
}
