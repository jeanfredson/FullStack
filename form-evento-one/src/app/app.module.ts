import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FormSaveComponent } from './components/form-save/form-save.component';
import { ListTableComponent } from './components/list-table/list-table.component';
import { ServiceService } from './shared/service.service';


@NgModule({
  declarations: [
    AppComponent,
    FormSaveComponent,
    ListTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
