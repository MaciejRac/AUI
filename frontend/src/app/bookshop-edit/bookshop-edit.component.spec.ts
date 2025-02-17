import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookshopEditComponent } from './bookshop-edit.component';

describe('BookshopEditComponent', () => {
  let component: BookshopEditComponent;
  let fixture: ComponentFixture<BookshopEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookshopEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookshopEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
