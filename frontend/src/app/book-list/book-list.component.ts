import { Component,OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../service/book-service.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  imports: [CommonModule,RouterModule],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{
  books: Book[]=[];

  constructor(private bookService: BookService,private router:Router) {
  }

  editBook(bookId: string): void {
    this.router.navigate(['/editBook', bookId]);
  }

  ngOnInit() {
    this.bookService.findAllBooks().subscribe(data => {
      this.books = data;
    });
  }
}
