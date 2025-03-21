import { Component ,OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book-service.service';
import { Book } from '../models/book';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BookshopService } from '../service/bookshop-service.service';
import { Bookshop } from '../models/bookshop';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-edit',
  imports: [FormsModule,CommonModule],
  templateUrl: './book-edit.component.html',
  styleUrl: './book-edit.component.css'
})
export class BookEditComponent implements OnInit{
  book:Book;
  bookshops:Bookshop[]=[];

  bookId: string | null = null;
  constructor(
    private route: ActivatedRoute,private router: Router ,private bookService: BookService,private bookshopService:BookshopService) {
    this.book = new Book();
  }
  ngOnInit(): void {
    this.bookId = this.route.snapshot.paramMap.get('id');
    console.log('Edit for book ID:', this.bookId);
    this.bookshopService.findAllBookshops().subscribe(data => {
      this.bookshops = data;
    });
  }
  onSubmit() {
    if (this.bookId) {
        this.bookService.editBook(this.bookId, this.book).subscribe({
            next: () => this.gotoBookList(),
            error: err => console.error('Błąd podczas edycji książki:', err)
        });
    } else {
        console.error('ID książki jest nieprawidłowe!');
    }
  }
  
  gotoBookList() {
    this.router.navigate(['/books']);
  }
}