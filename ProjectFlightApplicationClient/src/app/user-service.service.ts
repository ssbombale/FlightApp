import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import SearchFlightModel from './Admin/Model/SearchFlightModel';


//  const BASE_URL_USER = "http://localhost:9090/api/";
const BASE_URL_USER = "http://ec2-18-237-225-240.us-west-2.compute.amazonaws.com:9090/api/";

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(public http: HttpClient) { }

  searchFlights(searchFlightModel: SearchFlightModel) {
    return this.http.post(BASE_URL_USER + "user/flightctrl/searchFlight", searchFlightModel)
  }


  ticketbook(searchFlightModel: any) {
    return this.http.post(BASE_URL_USER + "user/flightctrl/ticketBook", searchFlightModel)
  }


  searchTicket(pnrnumber: string, usermode: string) {
    return this.http.get(BASE_URL_USER + "user/flightctrl/searchTicket/" + pnrnumber + "/" + usermode)
  }


  searchTicketByUserName(pnrnumber: string) {
    return this.http.get(BASE_URL_USER + "user/flightctrl/searchByUserName/" + pnrnumber )
  }


  cancelTicket(pnrnumber: string, usermode: string) {
    return this.http.get(BASE_URL_USER + "user/flightctrl/cancelTicket/" + pnrnumber + "/" + usermode)
  }

  getMealType(flightId:number) {
    return this.http.get(BASE_URL_USER + "user/flightctrl/getMealType/" + flightId )
  }


  getticketFare(tickeyType:string,flightId:number, passangeDetails:any ){
    console.log(flightId);
    console.log(passangeDetails);
    return this.http.put(BASE_URL_USER + "user/flightctrl/getTicketFare/" + tickeyType+"/"+flightId, passangeDetails )

  }

}
