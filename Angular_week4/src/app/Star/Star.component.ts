import {Component,OnChanges,Input,Output,EventEmitter}  from "@angular/core"

@Component({
    selector:"Star-edu",
    templateUrl:"Star.component.html",
    styleUrls:["Star.component.css"]
})


export class StarComponent implements OnChanges{
    @Input()    Rating:number;
                StarWidth:number;
    @Output()   RatingClicked:EventEmitter<string>=new EventEmitter<string>()

    ngOnChanges():void{
        this.StarWidth=this.Rating*86/5;
    }
    starClicked():void{
        this.RatingClicked.emit(`${this.Rating}`)
    }
}