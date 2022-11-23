import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {DetailsComponent} from "./details/details.component";
import {CardComponent} from "./card/card.component";


const routes: Routes = [
  {path: '',component: HomeComponent},
  {path: 'login',component: LoginComponent}
  // {path: '/home/details',component: DetailsComponent},
  // {path: '/home/card',component: CardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
