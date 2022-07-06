import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import AirLine from '../Model/AirLine';
import CreateFlight from '../Model/Createfilght';

@Component({
  selector: 'app-editflight',
  templateUrl: './editflight.component.html',
  styleUrls: ['./editflight.component.css']
})
export class EditflightComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['flightId'];
    this.viewflights();
    this.getAllAirline();
  }
  airline: AirLine[] = []

  id: number = 0;
  airLine: AirLine = new AirLine;
  createFlight: CreateFlight = new CreateFlight;

  viewflights() {
    const promise = this.adminService.getflightdetailsbyId(this.id);
    promise.subscribe((response) => {
      this.createFlight = response as CreateFlight;
      console.log(this.createFlight);
    })
  }

  getAllAirline() {
    const promise = this.adminService.getAllAirlineList();
    promise.subscribe((response) => {
      console.log(response);
      this.airline = response as AirLine[];
      console.log(this.airline);

    })
  }
  cancelsave() {
    this.router.navigate(['/showflight'])
  }


  updateFlight(){
    const promise = this.adminService.updateFlightbyId(this.id,this.createFlight);
    promise.subscribe((response) => {
     console.log(response);
     this.router.navigate(['showflight']);
    })  
  }


}
