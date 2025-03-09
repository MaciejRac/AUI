import { Component ,OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Bookshop } from '../models/bookshop';
import { BookshopService } from '../service/bookshop-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bookshop-details',
  imports: [CommonModule],
  templateUrl: './bookshop-details.component.html',
  styleUrl: './bookshop-details.component.css'
})
export class BookshopDetailsComponent implements OnInit {
  bookshop: Bookshop;
  bookshopId: string | null = null;
  message: string='';
  constructor(private bookshopService: BookshopService,private route: ActivatedRoute) {
    this.bookshop=new Bookshop;
   }

 ngOnInit() :void{
  this.bookshopId = this.route.snapshot.paramMap.get('id');
  if(this.bookshopId){
    this.bookshopService.getBookshopById(this.bookshopId).subscribe(data => {
      this.bookshop = data;
      //this.bookshop.liczba_pracownikow=12;
    });
}
else{
  console.error("Blad bookshop ID")
}
}
}
