import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ServiceService } from '../../shared/service.service';
import { User } from '../user';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  private formulario: FormGroup;

  private userErro: User;
  private user = new User();
  private flag = false;

  constructor(
    private formBuilder: FormBuilder,
    private service: ServiceService
  ) {}

  ngOnInit() {

    this.user = this.service.getter();
    console.log(this.user);

    this.dados(this.user);
  }

  create() {
    // tslint:disable-next-line:triple-equals
    if (this.user.id == undefined) {
      this.service.createService(this.formulario.value).subscribe(
        data => {
          console.log(data);
          this.flag = true;
          this.formulario.reset();
        },
        erro => {
          // tslint:disable-next-line:triple-equals
          if (erro.status == 406) {
            this.userErro = erro.error;
          }
          console.log(erro);
        }
      );
    } else {

      this.service.update(this.user).subscribe(
        data => {
          this.dados(data);
          console.log(data);
          this.flag = true;
          this.formulario.reset();
        },
        erro => {
          // tslint:disable-next-line:triple-equals
          if (erro.status == 406) {
            this.userErro = erro.error;
          }
          console.log(erro);
        }
      );
    }
  }

  clear() {
    this.formulario.reset();
  }

  dados(dados) {

    this.formulario = this.formBuilder.group({
      nome: [dados.nome, [Validators.required]],
      email: [dados.email, [Validators.email, Validators.required]],
      senha: [dados.senha, [Validators.required]],
      idade: [dados.idade, [Validators.required]],
      telefone: [dados.telefone, [Validators.required]]
    });
  }
}
