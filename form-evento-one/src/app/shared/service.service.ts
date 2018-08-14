import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class ServiceService {

  private url = 'http://localhost:8080/evento/';
  private header = new Headers({'content-type' : 'application/json'});
  private options = new RequestOptions({headers: this.header});

  constructor(
    private http: Http
  ) { }


  consultaCEP(cep, form) {
    cep = cep.replace(/\D/g, '');
    // tslint:disable-next-line:triple-equals
    if (cep != '') {
      const validacep = /^[0-9]{8}$/;

      if (validacep.test(cep)) {
        return this.http.get(`//viacep.com.br/ws/${cep}/json`).map(data => data.json()).catch(this.getErro);
      }
    }
  }

  create(user) {
    return this.http.post(this.url + 'salvar' + JSON.stringify(user), this.options).map(data => data.json()).catch(this.getErro);
  }






  getErro(erro: Response) {
    return Observable.throw(erro || 'Erro No Servidor');
  }

}
