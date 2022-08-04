import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MutualTabsComponent} from "./components/mutual-tabs/mutual-tabs.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {UserRegisterComponent} from "./components/user-register/user-register.component";

const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'register', component: UserRegisterComponent},
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
