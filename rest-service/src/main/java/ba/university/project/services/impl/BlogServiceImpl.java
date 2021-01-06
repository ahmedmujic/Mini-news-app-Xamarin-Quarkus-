package ba.university.project.services.impl;

import ba.university.project.respository.BlogRepository;
import ba.university.project.respository.entity.Blog;
import ba.university.project.services.BlogService;
import ba.university.project.services.model.BlogsDto;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class BlogServiceImpl implements BlogService {

    private static ModelMapper modelMapper = new ModelMapper();
    @Inject
    BlogRepository blogRepository;

    @Override
    public BlogsDto addNews(BlogsDto news) {
        Blog blog = modelMapper.map(news, Blog.class);
        Blog addedBlog = blogRepository.add(blog);
        return modelMapper.map(addedBlog, BlogsDto.class);
    }

    @Override
    public List<BlogsDto> allNews() {
        List<BlogsDto> blogsDto = new ArrayList<>();
        blogRepository.allBlogs().forEach(blog -> {
            BlogsDto blogsDto1 = new BlogsDto();
            blogsDto1.setId(blog.getId());
            blogsDto1.setTitle(blog.getTitle());
            blogsDto1.setCategory(blog.getCategory());
            blogsDto1.setContent(blog.getContent());
            blogsDto1.setDescription(blog.getDescription());
            blogsDto1.setPicture(blog.getPicture());
            blogsDto1.setDate(java.util.Date.from(blog.getCreatedOn().atZone(ZoneId.systemDefault()).toInstant()));
            blogsDto.add(blogsDto1);
        });

        return blogsDto;
    }
}
