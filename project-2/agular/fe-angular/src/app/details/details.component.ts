import {Component, OnInit} from '@angular/core';
import {IBookDto} from "../model/ibook-dto";
import {ShopService} from '../service/shop.service';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {TokenService} from "../service/token.service";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  book: IBookDto = null;
  id: number;

  constructor(private shopService: ShopService, private router: Router, private route: ActivatedRoute, private tokenService: TokenService) {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get("id")
    })
  }


  ngOnInit(): void {
      this.shopService.getDetailBook(this.id).subscribe(n => {
        console.log(n);
        this.book = n;
      })

  }
}
