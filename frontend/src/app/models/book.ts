import { Bookshop } from './bookshop';

export class Book {
   id?:string;
   nazwa?:string;
   rok_wydania?: number;
   bookshopId?: string; // tutaj nie wiem czy bedzie git

   constructor(id?: string, nazwa?: string, rok_wydania?: number, bookshop?: string) {
      this.id = id;
      this.nazwa = nazwa;
      this.rok_wydania = rok_wydania;
      this.bookshopId = bookshop;
   }
}