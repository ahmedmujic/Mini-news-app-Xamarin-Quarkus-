using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Blog
{
    public partial class MainPage : ContentPage
    {
        public IList<Blog> Blogs { get; private set; }
        public MainPage()
        {
            InitializeComponent();
            Blogs = new List<Blog>();
            Blogs.Add(new Blog
            {
                NewsImageUrl = "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/35px-Flag_of_France.svg.png",
                description = "Neki desc",
                Title = "Ttile"

            });
            BindingContext = this;
        }
    }
}
