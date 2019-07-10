import { Component } from '@angular/core';

@Component({
    selector: 'app-databind',
    templateUrl: './databind.component.html'
})
export class DatabindComponent{

    name: string = 'Ron';
    email: string = 'ronrox@gmail.com';

    person = {name: 'Paul', email: 'pauly@hotmail.com'};

}