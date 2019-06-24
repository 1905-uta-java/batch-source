import { Injectable } from "@angular/core"
import {IProduct} from "./products"
import{Http,Response} from "@angular/http"
import{Observable} from "rxjs/observable"
import "rxjs/add/operator/map"
import "rxjs/add/operator/catch"

@Injectable()



export class PipeCompoenet{
    private _ProductUrl="https://ngapi4.herokuapp.com/api/getProducts"
    constructor(private _http:Http){}

    getProducts():Observable <IProduct[]>{
        return this._http.get(this._ProductUrl)
        .map((response:Response)=><IProduct[]>response.json())
        .catch(this.Errorhandler);
    }

    private Errorhandler(error:Response){
        return Observable.throw(error.json().error||"Servive Error")
    }
}