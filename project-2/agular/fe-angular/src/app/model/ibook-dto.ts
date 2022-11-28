import {Category} from './category';

export interface IBookDto {
  id?: number;
  height?: number,
  price?: number,
  imageUrl?: string,
  publisher?: string,
  totalPages?: string,
  title?: string,
  width?: number,
  author?: string,
  categories: Category,
  summary?: string,
  quantity: number
}
