import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ConnectionsComponent } from './components/connections/connections.component';
import { RequestsComponent } from './components/requests/requests.component';
import { BlockedComponent } from './components/blocked/blocked.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { UserRegisterComponent } from './components/user-register/user-register.component';
import { UserSearchComponent } from './components/user-search/user-search.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProfileComponent } from './components/profile/profile.component';
import { ProfileTabsComponent } from './components/profile-tabs/profile-tabs.component';
import {NgbNavModule} from "@ng-bootstrap/ng-bootstrap";
import { MutualTabsComponent } from './components/mutual-tabs/mutual-tabs.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { BrowserUsersComponent } from './components/browser-users/browser-users.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ConnectionsComponent,
    RequestsComponent,
    BlockedComponent,
    RecommendationsComponent,
    UserRegisterComponent,
    UserSearchComponent,
    ProfileComponent,
    ProfileTabsComponent,
    MutualTabsComponent,
    NotFoundComponent,
    HomepageComponent,
    BrowserUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbNavModule,
    ReactiveFormsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
