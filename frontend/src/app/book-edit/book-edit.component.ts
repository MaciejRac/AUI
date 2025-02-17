import { Component ,OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book-service.service';
import { Book } from '../models/book';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-book-edit',
  imports: [FormsModule],
  templateUrl: './book-edit.component.html',
  styleUrl: './book-edit.component.css'
})
export class BookEditComponent {
  book:Book;
  id: string='';
  constructor(
    private route: ActivatedRoute,
       private router: Router,
          private bookService: BookService) {
    this.book = new Book();
  }

  onSubmit() {
    this.bookService.editBook(this.id,this.book).subscribe(result => this.gotoBookList());
}

  
  gotoBookList() {
    this.router.navigate(['/books']);
  }
}