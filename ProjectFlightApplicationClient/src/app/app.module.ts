import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Authentication/login/login.component';
import { LoginsuccessComponent } from './Authentication/loginsuccess/loginsuccess.component';
import { HeaderComponent } from './Menu/header/header.component';
import { LogoutComponent } from './Authentication/logout/logout.component';
import { ShowairlineComponent } from './Admin/showairline/showairline.component';
import { ShowflightsComponent } from './Admin/showflights/showflights.component';
import { CreateairlineComponent } from './Admin/createairline/createairline.component';
import { EditairlineComponent } from './Admin/editairline/editairline.component';
import { CreateflightComponent } from './Admin/createflight/createflight.component';
import { EditflightComponent } from './Admin/editflight/editflight.component';
import { SearchflightComponent } from './Ticket/searchflight/searchflight.component';
import { TicketbookComponent } from './Ticket/ticketbook/ticketbook.component';
import { TicketsuccessComponent } from './Ticket/ticketsuccess/ticketsuccess.component';
import { ViewticketComponent } from './Ticket/viewticket/viewticket.component';
import { ReviewticketComponent } from './Ticket/reviewticket/reviewticket.component';
import { CancelticketComponent } from './Ticket/cancelticket/cancelticket.component';
import { TicketshowComponent } from './Ticket/ticketshow/ticketshow.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginsuccessComponent,
    HeaderComponent,
    LogoutComponent,
    ShowairlineComponent,
    ShowflightsComponent,
    CreateairlineComponent,
    EditairlineComponent,
    CreateflightComponent,
    EditflightComponent,
    SearchflightComponent,
    TicketbookComponent,
    TicketsuccessComponent,
    ViewticketComponent,
    ReviewticketComponent,
    CancelticketComponent,
    TicketshowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
