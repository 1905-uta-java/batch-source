import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HighlightComponent } from './components/highlight/highlight.component';
import { TableComponent } from './componenets/table/table.component';
import { SelectComponent } from './components/select/select.component';
import { ProfileComponent } from './components/profile/profile.component';
import { UserComponent } from './components/user/user.component';
import { from } from 'rxjs';

const routes: Routes = [
    {
      path: 'highlight',
      component: HighlightComponent
    },{
      path: 'table',
      component: TableComponent
    }, {
      path: 'select',
      component: SelectComponent
    }, {
      path: 'profile',
      component: ProfileComponent
    }, {
      path: 'user',
      component: UserComponent
    }, {
      path: '**',
      pathMatch: 'full',
      redirectTo: ''
    }
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }