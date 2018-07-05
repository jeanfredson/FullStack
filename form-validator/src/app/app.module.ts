import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { ServiceService } from './shared/service.service';

import { AppComponent } from './app.component';
import { FormCadastroComponent } from './componente/form-cadastro/form-cadastro.component';
import { ListaCadastroComponent } from './componente/lista-cadastro/lista-cadastro.component';


@NgModule({
  declarations: [
    AppComponent,
    FormCadastroComponent,
    ListaCadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [ ServiceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
