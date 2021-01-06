using Refit;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Blog.Interface
{
    public interface IApi
    {
        [Get("/hello/blog")]
        Task<List<Blog>> GetBlog();
    }
}
