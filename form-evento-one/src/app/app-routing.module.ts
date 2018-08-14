import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormSaveComponent } from './components/form-save/form-save.component';
import { ListTableComponent } from './components/list-table/list-table.component';

const routes: Routes = [
  {path: 'cadastro', component: FormSaveComponent},
  {path: 'lista', component: ListTableComponent},
  {path: '', pathMatch: 'full', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
