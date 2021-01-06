using System;
using System.Collections.Generic;
using System.Text;

namespace Blog
{
    public class Blog
    {

        public int Id { get; set; }
        public string Picture { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Double Date { get; set; }
        public String DateString { get; set; }

        public string Content { get; set; }
        public string Category { get; set; }
    }
}
