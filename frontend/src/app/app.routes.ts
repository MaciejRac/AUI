import { Routes , RouterModule} from '@angular/router';
import { NgModule } from '@angular/core';
import { BookListComponent } from './book-list/book-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import { AppComponent } from './app.component';
import { BookshopListComponent } from './bookshop-list/bookshop-list.component';
import { BookshopFormComponent } from './bookshop-form/bookshop-form.component';
import { BookEditComponent } from './book-edit/book-edit.component';
import { BookshopEditComponent } from './bookshop-edit/bookshop-edit.component';

export const routes: Routes = [
  { path: 'books', component: BookListComponent },
   { path: 'addbook', component: BookFormComponent }
   ,{path:'bookshops',component:BookshopListComponent}
   ,{path:'addbookshop',component:BookshopFormComponent},
   //,{path:'editBook', component:BookEditComponent}
   //,{path:'editBookshop',component:BookshopEditComponent},
   {path:'editBook/:id',component:BookEditComponent},
   {path:'editBookshop/:id',component:BookshopEditComponent}
   ,{ path: '', redirectTo: '/bookshops', pathMatch: 'full' } // Przekierowanie do "/books"
  // ,{ path: '**', redirectTo: '/books' }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
