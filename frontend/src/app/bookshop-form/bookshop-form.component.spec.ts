import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookshopFormComponent } from './bookshop-form.component';

describe('BookshopFormComponent', () => {
  let component: BookshopFormComponent;
  let fixture: ComponentFixture<BookshopFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookshopFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookshopFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
