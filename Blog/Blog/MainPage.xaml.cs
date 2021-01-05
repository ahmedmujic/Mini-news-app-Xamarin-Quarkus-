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
        public IList<Blog>Blogs { get; set; }
        public MainPage()
        {
            InitializeComponent();
            Blogs = new List<Blog>(); 
        }
    }
}
