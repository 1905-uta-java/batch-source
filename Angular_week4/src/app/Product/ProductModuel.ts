import {NgModule} from "@angular/core"
import { RouterModule } from "@angular/router";
import { PipeCompoenet } from "./pipe";
import { ProductComponent } from "./Product.component";
import { Productservice } from "./ProductService";
import { ProductDetail } from "./Product-detail.component";

import { ShareModuel } from "../sharedModuel";


@NgModule({
  imports:[
    ShareModuel,
    RouterModule.forChild([
    {path:"Products",component:ProductComponent},
    {path:"Products/:id",component:ProductDetail},
    ])
  ],
  declarations:[
    ProductComponent,
    Productservice,
    ProductDetail
  ],

  providers:[
    PipeCompoenet
  ]
})

export class ProductModule{}