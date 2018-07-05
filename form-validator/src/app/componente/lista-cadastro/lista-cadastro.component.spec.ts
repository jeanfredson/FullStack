import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCadastroComponent } from './lista-cadastro.component';

describe('ListaCadastroComponent', () => {
  let component: ListaCadastroComponent;
  let fixture: ComponentFixture<ListaCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
