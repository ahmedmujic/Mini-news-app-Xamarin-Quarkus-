using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Blog
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Details : ContentPage
    {
        public Details(Blog blog)
        {
            InitializeComponent();
            Image.Source = blog.Picture;
            Title.Text = blog.Title;
            Description.Text = blog.Description;
            Category.Text = blog.Category;
            Content.Text = blog.Content;
        }
    }
}