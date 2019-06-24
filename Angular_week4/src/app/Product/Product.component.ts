import {Component,OnInit} from "@angular/core"
import{IProduct} from "./products"
import {PipeCompoenet} from "./pipe"

@Component({
    selector:"Pro-edu",
    templateUrl:"Product.component.html",
    styleUrls:["Product.component.css"]
})

export class ProductComponent implements OnInit{
    ErrorMessage:string
    Rate:string='';
    ShowImage:Boolean=false;
    Products:IProduct[]

    constructor( private _Prodiver:PipeCompoenet){}

    ToggleImage():void{
        this.ShowImage=!this.ShowImage
    }
    star(message:string):void{
        this.Rate=message
    }

    ngOnInit():void{
        this._Prodiver.getProducts()
        .subscribe((Products)=>this.Products=Products,
            (error)=>this.ErrorMessage=<any>error)
    }
}