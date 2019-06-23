import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-question5',
  templateUrl: './question5.component.html',
  styleUrls: ['./question5.component.css']
})
export class Question5Component implements OnInit {

  people: Post []=[];

  constructor(private postService: PostService) { }

  ngOnInit() {
  }

  getPosts(){
    this.postService.getPosts()
      .subscribe((allPosts)=>{
        this.people = allPosts;
      });
  }

}
