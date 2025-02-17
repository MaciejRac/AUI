import { Component } from '@angular/core';
import { Bookshop } from '../models/bookshop';
import { BookshopService } from '../service/bookshop-service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bookshop-list',
  imports: [CommonModule],
  templateUrl: './bookshop-list.component.html',
  styleUrl: './bookshop-list.component.css'
})
export class BookshopListComponent {
 bookshops: Bookshop[]=[];

  constructor(private bookshopService: BookshopService) {
  }

  ngOnInit() {
    this.bookshopService.findAllBookshops().subscribe(data => {
      this.bookshops = data;
    });
  }
}
