import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ConnectionsComponent} from "./components/connections/connections.component";
import {RequestsComponent} from "./components/requests/requests.component";
import {BlockedComponent} from "./components/blocked/blocked.component";

const routes: Routes = [
  // {path: '', component: HomepageComponent},
  {path: 'connections', component: ConnectionsComponent},
  {path: 'requests', component: RequestsComponent},
  {path: 'blocks', component: BlockedComponent},
  // {path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
