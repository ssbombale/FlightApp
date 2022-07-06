import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import AirLine from '../Model/AirLine';

@Component({
  selector: 'app-editairline',
  templateUrl: './editairline.component.html',
  styleUrls: ['./editairline.component.css']
})
export class EditairlineComponent implements OnInit {

  constructor(private adminService:AdminServiceService,
     private route: ActivatedRoute, private router: Router) { }


  id: number = 0;
  airLine: AirLine = new AirLine;


  ngOnInit(): void {
    
    this.id = this.route.snapshot.params['airlineId'];
    this.viewairline();
  }


  viewairline() {
    const promise = this.adminService.getAirlinebyId(this.id);
    promise.subscribe((response) => {
      this.airLine = response as AirLine;
      console.log(this.airLine);
    })

  }


  updateairline(){
    const promise = this.adminService.updateAirlinebyId(this.id,this.airLine);
    promise.subscribe((response) => {
     console.log(response);
     this.router.navigate(['showairline']);
    })  
  }


  cancel(){
    this.router.navigate(['showairline']);
  }
}
