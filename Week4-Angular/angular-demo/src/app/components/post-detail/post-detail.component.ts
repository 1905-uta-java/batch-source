import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  currentPost: Post = {
    id: undefined,
    userId: undefined,
    title: undefined,
    body: undefined
  }

  constructor(private postService: PostService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(param=>{
      this.currentPost.id = param['id'];
      this.getPost(this.currentPost.id);
    })
  }

  getPost(idParam: number){
    this.postService.getPost(idParam)
      .then((response)=>{
        this.currentPost = response;
      })
      .catch((e)=>console.log(e));

  }

}
