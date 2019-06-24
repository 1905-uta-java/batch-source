import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/components/post.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

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
