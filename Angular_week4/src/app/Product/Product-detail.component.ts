import { Component,OnInit } from "@angular/core"
import {ActivatedRoute,Router} from "@angular/router"


@Component({
    templateUrl:"Product-detail.component.html",
})

export class ProductDetail implements OnInit{
    title:string="";
    Name:string;
    desc:string;
    img:string;




    constructor(private _Router:ActivatedRoute, private _r:Router){}


    ngOnInit():void{
        let id = + this._Router.snapshot.params["id"]
        this.title+=`${id}`

        this._Router.queryParams.subscribe((params)=>{
            this.Name= params["Name"]
            this.img= params["img"]
            this.desc=params["desc"]

        })
    }

    Back():void{
        this._r.navigate(["/Products"])
    }
}