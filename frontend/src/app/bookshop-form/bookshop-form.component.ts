import { Component } from '@angular/core';
import { Bookshop } from '../models/bookshop';
import { ActivatedRoute, Router } from '@angular/router';
import { BookshopService } from '../service/bookshop-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-bookshop-form',
  imports: [FormsModule],
  templateUrl: './bookshop-form.component.html',
  styleUrl: './bookshop-form.component.css'
})
export class BookshopFormComponent {
  bookshop:Bookshop;
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private bookshopService: BookshopService) {
    this.bookshop = new Bookshop();
  }
  
  onSubmit() {
    this.bookshopService.saveBookshop(this.bookshop).subscribe(result => this.gotoBookshopList());
  }

  gotoBookshopList() {
    this.router.navigate(['/bookshops']);
  }
}
