import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import { UserServiceService } from 'src/app/user-service.service';
import SearchFlightModel from '../Model/SearchFlightModel';


@Component({
  selector: 'app-searchflight',
  templateUrl: './searchflight.component.html',
  styleUrls: ['./searchflight.component.css']
})
export class SearchflightComponent implements OnInit {

  constructor(private userService: UserServiceService,  private router: Router) { }

  ngOnInit(): void {
    this.searchFlightModel.searchType = 'oneway'
    this.showDetails=false;
  }


  showFlight: SearchFlightModel[] = []
  returnFlight: SearchFlightModel[] = []
  type:string="";

  showDetails:boolean = false;
  searchFlightModel: SearchFlightModel = new SearchFlightModel();

  getSearchFlight() {
    const promise = this.userService.searchFlights(this.searchFlightModel);
    promise.subscribe((response: any) => {
      console.log(response);
      this.showFlight = response.oneWayTrip as SearchFlightModel[];
      this.returnFlight = response.returnTrip as SearchFlightModel[];
      this.showDetails=true;
      this.type=response.tripType;
      console.log(this.showFlight);
      console.log(this.returnFlight);
    })
  }
  

  ticketBook(flightId:number){
    this.router.navigate(['ticketbook', flightId]);
  }
activateedit:boolean=false;
searchWind:boolean=true;

emp:SearchFlightModel = new SearchFlightModel;

  editClick(items:SearchFlightModel){
    
    this.emp=items;
    this.activateedit=true;
    this.searchWind=false;

    // [emp]="emp"
    
    //this.router.navigate(['ticketbook', JSON.stringify(this.emp) ]);
    
  }


}
