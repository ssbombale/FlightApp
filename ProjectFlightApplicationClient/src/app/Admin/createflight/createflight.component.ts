import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import AirLine from '../Model/AirLine';
import CreateFlight from '../Model/Createfilght';

@Component({
  selector: 'app-createflight',
  templateUrl: './createflight.component.html',
  styleUrls: ['./createflight.component.css']
})
export class CreateflightComponent implements OnInit {

  airline: AirLine[] = []
  constructor(private adminService:AdminServiceService,  private router:Router) { }
  createFlight:CreateFlight = new CreateFlight();
  ngOnInit(): void {
//    this.createFlight.flighttravelDays="AllDays";
    this.createFlight.flighttravelDays="AllDays";
    this.createFlight.mealType = "Veg";
    this.getAllAirline();
  }




  getAllAirline() {
    const promise = this.adminService.getAllAirlineList();
    promise.subscribe((response) => {
      console.log(response);
 
      this.airline = response as AirLine[];
      console.log(this.airline);
      
    })
  }

  saveFlight(){
    const promise = this.adminService.createFlight(this.createFlight);
    promise.subscribe((response) => {
      console.log(response);
  
      this.router.navigate(['/showflight'])
    })
  }


  cancelsave(){
    this.router.navigate(['/showflight'])
  }

}
