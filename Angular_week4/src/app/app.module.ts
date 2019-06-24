import {NgModule} from "@angular/core"
import {BrowserModule} from "@angular/platform-browser"
import{RouterModule} from "@angular/router"
import {HttpModule} from "@angular/http"
import {FormsModule} from "@angular/forms"
import {AppComponent} from "./app.component"


import { NotFound } from "./NotFound";

import { OrderComponent } from "./Order/Order.component";
import { HomeComponent } from "./Home/Home.component";
import { ProductModule } from "./Product/ProductModuel";


@NgModule({
  imports:[
    BrowserModule,
    ProductModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path:"Home",component:HomeComponent},
      {path:"Order",component:OrderComponent},
      {path:"",redirectTo:"Home",pathMatch:"full"},
      {path:"**",component:NotFound}
    ])
  ],
  declarations:[
    AppComponent,

    NotFound,
    OrderComponent,
    HomeComponent
  ],
  bootstrap:[
    AppComponent
  ]
})

export class AppModule{}