import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ServiceService } from '../../shared/service.service';
import { User } from '../../user';
import { Observable } from 'rxjs/Observable';
import { isArray } from 'util';

@Component({
  selector: 'app-form-cadastro',
  templateUrl: './form-cadastro.component.html',
  styleUrls: ['./form-cadastro.component.css']
})
export class FormCadastroComponent implements OnInit {

  form: FormGroup;
  lista: Array<string>;
  user = new User;

  constructor(
    private formBuilder: FormBuilder,
    private service: ServiceService,

  ) { }

  ngOnInit() {

    this.form = this.formBuilder.group({
      nome: [null, [Validators.maxLength(40), Validators.minLength(2)]],
      email: [null, [Validators.email, Validators.required]],
      telefone: [null, [Validators.pattern('^\([1-9]{2}\) [2-9][0-9]{3,4}\-[0-9]{4}$')]]
    });

    this.listForm();
  }

  createForm() {
   console.log(this.form.value);
   this.service.create(this.form.value).subscribe(data => {
     console.log(data);
    this.form.reset();
   }, erro => {
     console.log(erro);
   });
  }

  listForm() {
    this.service.list().subscribe(resp => {
      console.log(resp);
      this.lista = resp;
    });
  }






}
