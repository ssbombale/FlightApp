import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import CreateFlight from '../Model/Createfilght';
import OutPutModel from '../Model/OutputModel';

@Component({
  selector: 'app-showflights',
  templateUrl: './showflights.component.html',
  styleUrls: ['./showflights.component.css']
})
export class ShowflightsComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }

  showFlight: CreateFlight[] = []

  ngOnInit(): void {
    this.refreshAllflights();
  }
  flightSerach: String = "";


  refreshAllflights() {
    const promise = this.adminService.getAllFlightList();
    promise.subscribe((response) => {
      console.log(response);
      this.showFlight = response as CreateFlight[];
    })


  }


  searchByFlightName() {
    if (this.flightSerach == "") {
      this.refreshAllflights()
    } else {
      console.log(this.flightSerach);
      const promise = this.adminService.searchFlightByName(this.flightSerach);
      promise.subscribe((res) => {
        console.log(res);
        this.showFlight = res as CreateFlight[];
        console.log(this.showFlight)
      })
    }
  }


  updateFlights(flightId: number) {
    this.router.navigate(['editflight', flightId]);

  }
  outputmodel: OutPutModel = new OutPutModel


  cancelFlight(flightId: number){
    const promise = this.adminService.cancelFlight(flightId);
    promise.subscribe((res: any) => {
      console.log(res);
      this.outputmodel = res.status
      this.outputmodel = res.message
      this.refreshAllflights();

    })
  
  }


  activateFlight(flightId: number){
    const promise = this.adminService.activateFlight(flightId);
    promise.subscribe((res: any) => {
      console.log(res);
      this.outputmodel = res.status
      this.outputmodel = res.message
      this.refreshAllflights();

    })
  }

  


}
