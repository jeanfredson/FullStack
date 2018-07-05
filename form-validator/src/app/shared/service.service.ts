import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/add/operator/map';
import { User } from '../user';

@Injectable()
export class ServiceService {

  private httpHeader = {headers: new HttpHeaders({'Content-Type' : 'Application/json'})};
  private url = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }


  create(user) {
    return this.http.post(this.url + '/create', JSON.stringify(user), this.httpHeader).map(data => data);
  }

  list() {
    return this.http.get(this.url + '/list', this.httpHeader).map(data => data);
  }

}
