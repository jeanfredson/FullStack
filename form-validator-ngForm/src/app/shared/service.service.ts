import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { User } from '../component/user';

@Injectable()
export class ServiceService {

  private url = 'http://localhost:8080/form/';
  private header = {headers: new HttpHeaders({'Content-type' : 'Application/json'})};

  private user = new User();

  constructor(private http: HttpClient) { }


  listaService(): Observable<any> {
    return this.http.get(this.url + 'lista', this.header).map(data => data);
  }
  createService(user) {
    return this.http.post(this.url + 'create', user, this.header).map(data => data);
  }
  listaId(id: number) {
    return this.http.get(this.url + 'lista/' + id, this.header).map(data => data);
  }
  delete(id: number) {
    return this.http.delete(this.url + 'delete/' + id, this.header).map(data => data);
  }
  update(user) {
    return this.http.put(this.url + 'update/' + JSON.stringify(user) , this.header).map(data => data);
  }


  setter(user: User) {
    this.user = user;
  }
  getter() {
    return this.user;
  }

}
