import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import AirLine from './Admin/Model/AirLine';
import CreateFlight from './Admin/Model/Createfilght';


//  const BASE_URL_ADMIN = "http://localhost:9094/api/";

//http://ec2-18-236-113-167.us-west-2.compute.amazonaws.com:9090

 const BASE_URL_ADMIN = "http://ec2-18-237-225-240.us-west-2.compute.amazonaws.com:9094/api/";

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  public isUserLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(public http: HttpClient) { }


  login(login: { username: string, password: string }) {
    return this.http.post(BASE_URL_ADMIN + "admin/loginctrl/login", login)
  }

  getAllFlightList() {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });

    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/fetchAllFlight", requestOptions)
  }

  getAllAirlineList() {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/getAllAirLine", requestOptions)
  }


  searchAirLineByName(airlineName: String) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/searchAirlineByName/" +
      airlineName)
  }



  searchFlightByName(flightName: String) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/searchFlightByName/" + flightName, requestOptions)
  }



  getAirlinebyId(airlineId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/getAirLineId/" + airlineId, requestOptions)
  }


  createAirLine(airLine: AirLine) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.post(BASE_URL_ADMIN + "admin/adminCtrl/createAirLine", airLine, requestOptions);

  }

  createFlight(createFlight: CreateFlight) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.post(BASE_URL_ADMIN + "admin/adminCtrl/createNewFlight", createFlight, requestOptions);

  }

  getflightdetailsbyId(flightId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/getFlightDetailById/" + flightId, requestOptions);
  }



  activateAirline(airlineId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/activateAirline/" + airlineId, requestOptions);
  }

  deactivateAirline(airlineId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/deactivateAirline/" + airlineId, requestOptions);
  }


  //updateAirLine
  updateAirlinebyId(airlineId: number, airline: AirLine) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.put(BASE_URL_ADMIN + "admin/adminCtrl/updateAirLine/" + airlineId, airline, requestOptions)
  }


  updateFlightbyId(flightId: number, flightdetails: CreateFlight) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.put(BASE_URL_ADMIN + "admin/adminCtrl/updateFlight/" + flightId, flightdetails, requestOptions)
  }


  cancelFlight(flightId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/cancelFlight/" + flightId, requestOptions)
  }



  activateFlight(flightId: number) {
    const httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
    const requestOptions = { headers: httpOptions };
    return this.http.get(BASE_URL_ADMIN + "admin/adminCtrl/activateFlights/" + flightId, requestOptions)
  }


}
