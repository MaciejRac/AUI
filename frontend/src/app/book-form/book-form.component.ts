import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book-service.service';
import { Book } from '../models/book';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Bookshop } from '../models/bookshop';
import { CommonModule } from '@angular/common';
import { BookshopService } from '../service/bookshop-service.service';

@Component({
  selector: 'app-book-form',
  imports: [FormsModule,RouterModule,CommonModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent implements OnInit{
  bookshops: Bookshop[]=[];
  book:Book;
  constructor(
    private route: ActivatedRoute, private router: Router,
      private bookService: BookService, private bookshopService: BookshopService) {
    this.book = new Book();
    //this.book.bookshop=new Bookshop();
  }
  
  onSubmit() {
    this.bookService.saveBook(this.book).subscribe(result => this.gotoBookList());
  }

  gotoBookList() {
    this.router.navigate(['/books']);
  }
  ngOnInit(): void {
    this.bookshopService.findAllBookshops().subscribe(data => {
      this.bookshops = data;
    });
  }
}
