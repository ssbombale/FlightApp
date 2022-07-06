import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import AirLine from '../Model/AirLine';
import OutPutModel from '../Model/OutputModel';

@Component({
  selector: 'app-createairline',
  templateUrl: './createairline.component.html',
  styleUrls: ['./createairline.component.css']
})
export class CreateairlineComponent implements OnInit {

  airLine: AirLine = new AirLine();
  outputModel: OutPutModel = new OutPutModel();
  constructor(private adminService: AdminServiceService, private router: Router) { }

  ngOnInit(): void {
    
  }

  airlineSave() {
    
    const observable = this.adminService.createAirLine(this.airLine);
    observable.subscribe((res: any) => {
      console.log(res)
      this.outputModel.message = res.message;
      this.outputModel.status = res.status;
      window.setTimeout(function () {
        alert(res.message)
      }, 200)
      this.router.navigate(['/showairline'])
    })
  }
  cancel() {
    this.router.navigate(['/showairline'])
  }

}
