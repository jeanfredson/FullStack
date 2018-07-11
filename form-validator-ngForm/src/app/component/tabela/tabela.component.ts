import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../shared/service.service';
import { Router } from '@angular/router';
import { User } from '../user';


@Component({
  selector: 'app-tabela',
  templateUrl: './tabela.component.html',
  styleUrls: ['./tabela.component.css']
})
export class TabelaComponent implements OnInit {

  private user: Array<string> = [];

  constructor(
    private service: ServiceService,
    private router: Router
    ) { }

  ngOnInit() {
    this.listar();
  }


  listar() {
    this.service.listaService().subscribe(data => {
      console.log(data);
      this.user = data;
    }, erro => {
      console.log(erro);
    });
  }

  listaId(codigo: number) {
    console.log(codigo);
    this.service.listaId(codigo).subscribe(data => {
      console.log(data);
    }, (e) => {
      console.log(e);
    });
  }

  delete(codigo: number) {
    console.log(codigo);
    this.service.delete(codigo).subscribe(data => {
      console.log(data);
      // tslint:disable-next-line:no-unused-expression
      this.router.navigate(['/tabela']);
    }, (e) => {
      console.log(e);
    });
  }

  update(user) {
    this.service.setter(user);
    this.router.navigate(['/formulario']);
  }

}
