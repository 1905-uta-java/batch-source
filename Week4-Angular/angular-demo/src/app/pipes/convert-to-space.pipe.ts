import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToSpace'
})
export class ConvertToSpacePipe implements PipeTransform {

  transform(value: string, character?: any): string {
    let char = '-';
    if(character!==undefined){
      char = character;
    }
    for(let i = 0; i<value.length; i++){
      if(value.charAt(i)===char){
        value = value.substring(0,i)+' '+value.substring(i+1);
      }
    }
    return value;
  }

}
