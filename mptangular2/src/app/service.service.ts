import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
  import { from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseurl = "https://jsonplaceholder.typicode.com/posts";

  constructor(private http: HttpClient) { }


  getPost() {
    return this.http.get<any>(this.baseurl);
  }
}
