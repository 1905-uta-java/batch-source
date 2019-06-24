import {Pipe,PipeTransform} from "@angular/core"
import{IProduct} from "./products"


@Pipe({
    name:"ProductFilter"
})

export class Productservice implements PipeTransform{
    transform(value:IProduct[],filterBy:string):IProduct[]{
        filterBy= filterBy? filterBy.toLowerCase():null;
        return filterBy?value.filter((Product:IProduct)=>
        Product.productName.toLowerCase().indexOf(filterBy)!==-1):value;
    }
}

