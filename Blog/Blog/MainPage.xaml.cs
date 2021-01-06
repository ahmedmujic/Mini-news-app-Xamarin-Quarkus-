using Blog.Interface;
using Newtonsoft.Json.Linq;
using Refit;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Xamarin.Forms;

namespace Blog
{
    public partial class MainPage : ContentPage, INotifyPropertyChanged
    {
        public ObservableCollection<Blog> Blogs { get; private set; }
        private bool _isRefreshing = false;
        public bool IsRefreshing
        {
            get { return _isRefreshing; }
            set
            {
                _isRefreshing = value;
                OnPropertyChanged(nameof(IsRefreshing));
            }
        }
        public MainPage()
        {
            InitializeComponent();
            
            Blogs = new ObservableCollection<Blog>();
           

          


            Task.Run(async () =>
            {
                await LoadBlogs();
            });


            BindingContext = this;

        }
        public async Task LoadBlogs()
        {
            Console.WriteLine("uslo1");
            IApi myApi;
            Console.WriteLine("uslo1");
            myApi = RestService.For<IApi>("http://10.0.2.2:8080");
            Console.WriteLine("uslo2");
           
            List<Blog> blogs = await myApi.GetBlog();

            Blogs.Clear();
            foreach (Blog blog in blogs)
            {
                Blogs.Add(new Blog
                {
                    Id = blog.Id,
                    Title = blog.Title,
                    Description = blog.Description,
                    Picture = blog.Picture,
                    Content = blog.Content,
                    Category = blog.Category,
                    DateString = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc).AddSeconds(blog.Date / 1000).ToShortDateString()
            });
                
                Console.WriteLine(blog.Title);
              
            }
           
        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            await LoadBlogs();


        }

        private void Navigate(object sender, EventArgs e)
        {
            foreach (Blog blog in Blogs)
            {
                if(blog.Id == int.Parse((sender as Button).CommandParameter.ToString()))
                {
                    Navigation.PushAsync(new Details(blog));
                }
            }
                
        }

        public ICommand RefreshCommand
        {
            get
            {
                return new Command(async () =>
                {
                    IsRefreshing = true;

                    await LoadBlogs();

                    IsRefreshing = false;
                });
            }
        }
    }
}
