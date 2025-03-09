import { Book } from './book';

export class Bookshop {
    id?: string;
    nazwa?: string; 
    liczbaPracownikow?:number;
 
    constructor(id?: string, nazwa?: string, liczba_pracowanikow?:number) {
       this.id = id;
       this.nazwa = nazwa;
       this.liczbaPracownikow = liczba_pracowanikow
    }
}