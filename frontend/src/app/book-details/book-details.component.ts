import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../service/book-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-details',
  imports: [],
  templateUrl: './book-details.component.html',
  styleUrl: './book-details.component.css'
})
export class BookDetailsComponent implements OnInit {
 book: Book;
  bookId: string | null = null;
  constructor(private bookService: BookService,private route: ActivatedRoute) {
    this.book=new Book;
   }

 ngOnInit() :void{
  this.bookId = this.route.snapshot.paramMap.get('id');
  if(this.bookId){
    this.bookService.getBookById(this.bookId).subscribe(data => {
      console.log(data);
      this.book = data;
    });
}
else{
  console.error("Blad bookshop ID")
}
}
}
