import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../shared/service.service';

@Component({
  selector: 'app-form-save',
  templateUrl: './form-save.component.html',
  styleUrls: ['./form-save.component.css']
})
export class FormSaveComponent implements OnInit {
  constructor(private service: ServiceService) {}

  ngOnInit() {}

  populandoCEP(cep, form) {
    this.service.consultaCEP(cep, form).subscribe(data => {
      console.log(data);
      this.populandoDados(form, data);
      console.log(data, form);
    }, e => {
      console.log(e);
    });
  }

  submit(form) {
    this.service.create(form.value).subscribe(data => {
      console.log(data);
    }, e => {
      console.log(e);
    });
  }

  populandoDados(f, dados) {
    f.form.patchValue({
      cep: dados.cep,
      rua: dados.logradouro,
      complemento: dados.complemento,
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf
    });
  }
}
