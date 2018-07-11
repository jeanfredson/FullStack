import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './component/formulario/formulario.component';
import { TabelaComponent } from './component/tabela/tabela.component';

const routes: Routes = [
  {path: 'formulario', component: FormularioComponent},
  {path: 'tabela', component: TabelaComponent},
  {path: '', pathMatch: 'full', redirectTo: 'formulario'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
