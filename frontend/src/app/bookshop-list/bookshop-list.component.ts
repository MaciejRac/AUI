import { Component } from '@angular/core';
import { Bookshop } from '../models/bookshop';
import { BookshopService } from '../service/bookshop-service.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-bookshop-list',
  imports: [CommonModule,RouterModule],
  templateUrl: './bookshop-list.component.html',
  styleUrl: './bookshop-list.component.css'
})
export class BookshopListComponent {
 bookshops: Bookshop[]=[];

  constructor(private bookshopService: BookshopService, private router:Router) {
  }

  editBookshop(bookshopId: string): void {
    this.router.navigate(['/editBookshop', bookshopId]);
  }

  ngOnInit() {
    this.bookshopService.findAllBookshops().subscribe(data => {
      this.bookshops = data;
    });
  }
}
