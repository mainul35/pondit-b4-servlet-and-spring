import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ConnectionsComponent} from "./components/connections/connections.component";
import {RequestsComponent} from "./components/requests/requests.component";
import {BlockedComponent} from "./components/blocked/blocked.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {MutualTabsComponent} from "./components/mutual-tabs/mutual-tabs.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {HomepageComponent} from "./components/homepage/homepage.component";

const routes: Routes = [
  {path: '', component: HomepageComponent},
  // {path: 'profile', component: ProfileComponent},
  {path: 'mutuals', component: MutualTabsComponent},
  // {path: 'blocks', component: BlockedComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
