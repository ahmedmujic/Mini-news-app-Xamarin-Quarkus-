package ba.university.project.services;

import ba.university.project.services.model.BlogsDto;

import java.util.List;

public interface BlogService {
    BlogsDto addNews(BlogsDto news);
    List<BlogsDto> allNews();
}
