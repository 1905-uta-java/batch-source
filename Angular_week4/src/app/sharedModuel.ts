import {NgModule} from "@angular/core"
import {CommonModule} from "@angular/common"
import {FormsModule} from "@angular/forms"
import { StarComponent } from "./Star/Star.component";



@NgModule({
    imports:[
        CommonModule,
        FormsModule
    ],
    declarations:[
    StarComponent
    ],
    exports:[
        CommonModule,
        FormsModule,
        StarComponent
    ],
})

export class ShareModuel{}