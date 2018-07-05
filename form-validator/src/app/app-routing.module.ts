import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormCadastroComponent } from './componente/form-cadastro/form-cadastro.component';
import { ListaCadastroComponent } from './componente/lista-cadastro/lista-cadastro.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'formulario', component: FormCadastroComponent},
  {path: 'tabela', component: ListaCadastroComponent},
  {path: '', pathMatch: 'full', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
