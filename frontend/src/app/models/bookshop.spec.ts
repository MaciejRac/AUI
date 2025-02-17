import { Bookshop } from './bookshop';
import { Book } from './book';

describe('Bookshop', () => {
  it('should create an instance', () => {
    expect(new Bookshop("01","ksiegarnia",17)).toBeTruthy();
  });
});