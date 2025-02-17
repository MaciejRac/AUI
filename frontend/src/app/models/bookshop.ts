import { Book } from './book';

export class Bookshop {
    id?: string;
    nazwa?: string; 
    liczba_pracownikow?:number;
 
    constructor(id?: string, nazwa?: string, liczba_pracowanikow?:number) {
       this.id = id;
       this.nazwa = nazwa;
       this.liczba_pracownikow = liczba_pracowanikow
    }
}