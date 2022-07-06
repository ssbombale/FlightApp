import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import AirLine from '../Model/AirLine';
import OutPutModel from '../Model/OutputModel';

@Component({
  selector: 'app-showairline',
  templateUrl: './showairline.component.html',
  styleUrls: ['./showairline.component.css']
})
export class ShowairlineComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }

  ngOnInit(): void {
    this.refreshList();
  }
  exsitairline: AirLine = new AirLine;
  airline: AirLine[] = []
  airlinesearch: String = "";
  outputmodel: OutPutModel = new OutPutModel
  refreshList() {

    const promise = this.adminService.getAllAirlineList();
    promise.subscribe((response) => {
      this.airline = response as AirLine[];
      console.log('HelloWrold');


    });

  }

  updateAirline(airlineId: number) {
    this.router.navigate(['editairline', airlineId]);
  }

  showNotify: boolean = false
  acitve(airlineId: number) {
    const promise = this.adminService.activateAirline(airlineId);
    promise.subscribe((res: any) => {
      console.log(res);
      this.showNotify = true
      this.outputmodel = res.status
      this.outputmodel = res.message
      this.refreshList();

    })
   

    this.showNotify = true
  }

  deactive(airlineId: number) {
    const promise = this.adminService.deactivateAirline(airlineId);
    promise.subscribe((res: any) => {
      console.log(res);
      this.showNotify = true
      this.outputmodel = res.status
      this.outputmodel = res.message
      this.refreshList();

    })
    this.showNotify = true
  }


  searchByAirlineName() {

    if (this.airlinesearch == "") {
      this.refreshList()
    } else {
      console.log(this.airlinesearch);
      const promise = this.adminService.searchAirLineByName(this.airlinesearch);
      promise.subscribe((res) => {
        console.log(res);
        this.airline = res as AirLine[];
        console.log(this.airline)
        // this.refreshList()
      })

    }
  }


  editairline(airlineId: number) {
    this.router.navigate(['editairline', airlineId]);

  }

}
