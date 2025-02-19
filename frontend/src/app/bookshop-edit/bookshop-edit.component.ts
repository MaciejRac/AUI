import { Component, OnInit } from '@angular/core';
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
export class BookshopEditComponent implements OnInit {
 bookshop:Bookshop;
 id:string='';
 bookshopID: string | null = null;
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private bookshopService: BookshopService) {
    this.bookshop = new Bookshop();
  }
  ngOnInit(): void {
      this.bookshopID=this.route.snapshot.paramMap.get('id');
      console.log('Edit for bookshop ID:', this.bookshopID);
  }
  onSubmit() {
    if (this.bookshopID) {
        this.bookshopService.editBookshop(this.bookshopID, this.bookshop).subscribe({
            next: () => this.gotoBookshopList(),
            error: err => console.error('Błąd podczas edycji książki:', err)
        });
    } else {
        console.error('ID książki jest nieprawidłowe!');
    }
  }
  gotoBookshopList() {
    this.router.navigate(['/bookshops']);
  }
}
