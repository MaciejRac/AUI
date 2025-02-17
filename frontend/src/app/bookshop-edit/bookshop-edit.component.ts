import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Bookshop } from '../models/bookshop';
import { ActivatedRoute,Router } from '@angular/router'; 
import { BookshopService } from '../service/bookshop-service.service';

@Component({
  selector: 'app-bookshop-edit',
  imports: [FormsModule],
  templateUrl: './bookshop-edit.component.html',
  styleUrl: './bookshop-edit.component.css'
})
export class BookshopEditComponent {
 bookshop:Bookshop;
 id:string='';
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private bookshopService: BookshopService) {
    this.bookshop = new Bookshop();
  }
  onSubmit() {
      this.bookshopService.editBookshop(this.id,this.bookshop).subscribe(result => this.gotoBookshopList());
  }
  gotoBookshopList() {
    this.router.navigate(['/bookshops']);
  }
}
