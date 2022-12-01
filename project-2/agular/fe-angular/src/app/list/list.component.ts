import { Component, OnInit } from '@angular/core';
import {IBookDto} from "../model/ibook-dto";
import {ShopService} from "../service/shop.service";
import {TokenService} from "../service/token.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  books: IBookDto[];
  title: string = '';
  author: string = '';
  totalPage: number;
  page: number = 0;

  constructor(private shopService: ShopService, private tokenService:TokenService) {
  }

  ngOnInit(): void {
    this.getAllAndSearchBook();
  }

  getAllAndSearchBook() {
    this.page = 0;
    this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {
      this.books = n.content;
      this.totalPage = n.totalPages;
    });
  }

  next() {
    this.page = this.page + 1;
    return this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {
      this.books = n.content;
    });
  }

  previous() {
    this.page = this.page - 1;
    return this.shopService.getShop(this.title, this.author, this.page).subscribe(n => {
      this.books = n.content;
    });
  }
}
