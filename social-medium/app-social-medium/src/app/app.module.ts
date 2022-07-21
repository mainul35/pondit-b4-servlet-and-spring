import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ConnectionsComponent } from './components/connections/connections.component';
import { RequestsComponent } from './components/requests/requests.component';
import { BlockedComponent } from './components/blocked/blocked.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { UserRegisterComponent } from './components/user-register/user-register.component';
import { UserSearchComponent } from './components/user-search/user-search.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavbarComponent,
    ConnectionsComponent,
    RequestsComponent,
    BlockedComponent,
    RecommendationsComponent,
    UserRegisterComponent,
    UserSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
