import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-http-demo',
  templateUrl: './http-demo.component.html',
  styleUrls: ['./http-demo.component.css']
})
export class HttpDemoComponent implements OnInit {

  posts: Post[] = [];

  constructor(private postService: PostService) { }

  ngOnInit() {
  }

  getPosts(){
    //use post service to assign "posts" to an array of posts we get back from an HTTP request
    this.postService.getPosts()
      .subscribe((allPosts)=>{
        this.posts = allPosts;
      });
  }

}
