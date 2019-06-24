import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/post.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  persons: Post []=[];

  constructor(private postService: PostService) { }

  ngOnInit() {
  }

  getPosts(){
    this.postService.getPosts()
      .subscribe((allPosts)=>{
        this.persons = allPosts;
      });
  }
}
