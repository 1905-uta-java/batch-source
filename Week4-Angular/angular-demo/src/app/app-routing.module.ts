import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FirstComponent } from './components/first/first.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { DatabindComponent } from './components/databind/databind.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { ADirectivesComponent } from './components/a-directives/a-directives.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';
import { HttpDemoComponent } from './components/http-demo/http-demo.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';

const routes: Routes = [
  {
    path: 'first',
    component: FirstComponent
  },{
    path: 'clicker',
    component: ClickerComponent
  }, {
    path: 'databind',
    component: DatabindComponent
  }, {
    path: 'pipes',
    component: PipeDemoComponent
  }, {
    path: 'directives',
    component: DirectivesComponent,
    children: [
      {
        path: 'attribute',
        component: ADirectivesComponent
      },{
        path: 'structural',
        component: SDirectivesComponent
      }
    ]
  }, {
    path: 'posts',
    component: HttpDemoComponent
  }, {
    path: 'posts/:id',
    component: PostDetailComponent
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
