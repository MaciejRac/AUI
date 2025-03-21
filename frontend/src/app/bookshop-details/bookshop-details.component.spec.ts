import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookshopDetailsComponent } from './bookshop-details.component';

describe('BookshopDetailsComponent', () => {
  let component: BookshopDetailsComponent;
  let fixture: ComponentFixture<BookshopDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookshopDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookshopDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
