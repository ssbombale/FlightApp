import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateairlineComponent } from './Admin/createairline/createairline.component';
import { CreateflightComponent } from './Admin/createflight/createflight.component';
import { EditairlineComponent } from './Admin/editairline/editairline.component';
import { EditflightComponent } from './Admin/editflight/editflight.component';
import { ShowairlineComponent } from './Admin/showairline/showairline.component';
import { ShowflightsComponent } from './Admin/showflights/showflights.component';
import { LoginComponent } from './Authentication/login/login.component';
import { LoginsuccessComponent } from './Authentication/loginsuccess/loginsuccess.component';
import { LogoutComponent } from './Authentication/logout/logout.component';
import { CancelticketComponent } from './Ticket/cancelticket/cancelticket.component';
import { SearchflightComponent } from './Ticket/searchflight/searchflight.component';
import { TicketbookComponent } from './Ticket/ticketbook/ticketbook.component';
import { TicketsuccessComponent } from './Ticket/ticketsuccess/ticketsuccess.component';
import { ViewticketComponent } from './Ticket/viewticket/viewticket.component';

const routes: Routes = [
  {path:"login", component:LoginComponent},
  {path:"loginsuccess", component:LoginsuccessComponent},
  {path:"logout", component:LogoutComponent},
  {path:"showairline", component:ShowairlineComponent},
  {path:"showflight", component:ShowflightsComponent},
  {path:"editairline/:airlineId", component:EditairlineComponent},
  {path:"createairline", component:CreateairlineComponent},
  {path:"createflight", component:CreateflightComponent},
  {path:"editflight/:flightId", component:EditflightComponent},
  {path:"searchflight", component:SearchflightComponent},
   {path:"ticketbook/:item", component:TicketbookComponent},
   {path:"ticketSuccess",component:TicketsuccessComponent},
   {path:"viewTicket",component:ViewticketComponent},
   {path:"cancelTicket",component:CancelticketComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
