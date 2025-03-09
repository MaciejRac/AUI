import { Book } from './book';
import { Bookshop } from './bookshop';

describe('Book', () => {
  it('should create an instance', () => {
    let bookshop= new Bookshop("01","ksiegarnia",17);
    expect(new Book("01","book1",1864,"bookshop")).toBeTruthy();
  });
});
