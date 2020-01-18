import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private service:HttpService) { }
  posts:any[];

  ngOnInit() {
    this.service.getPost().subscribe(post=>{
      this.posts=post;
    })
  }

}