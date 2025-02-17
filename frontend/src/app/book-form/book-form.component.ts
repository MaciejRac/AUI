import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book-service.service';
import { Book } from '../models/book';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Bookshop } from '../models/bookshop';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-form',
  imports: [FormsModule,RouterModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent {
  book:Book;
  constructor(
    private route: ActivatedRoute, private router: Router,
      private bookService: BookService) {
    this.book = new Book();
    //this.book.bookshop=new Bookshop();
  }
  
  onSubmit() {
    this.bookService.saveBook(this.book).subscribe(result => this.gotoBookList());
  }

  gotoBookList() {
    this.router.navigate(['/books']);
  }
}
