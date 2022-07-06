import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-reviewticket',
  templateUrl: './reviewticket.component.html',
  styleUrls: ['./reviewticket.component.css']
})
export class ReviewticketComponent implements OnInit {

  
  constructor(private router:Router,private userService:UserServiceService) { }

  list:any
  res:any

  @Input() model:any
  ngOnInit(): void {
    console.log(this.model);
    this.list=this.model.passangerList;
    console.log(this.list);
    this.viewTicket=false;
    this.reviewTicket=true;
    console.log('------>>>>>   '+this.model.passangerList.lenth);
    this.getticketfare();
   
  }
viewTicket:boolean=false;
reviewTicket:boolean=false;

  ticketBook(){
    this.model.travelDate=this.model.searchDate;
    this.model
    const promise = this.userService.ticketbook(this.model);
    promise.subscribe((response:any) => {
      console.log(response);
      // this.router.navigate(['/ticketSuccess'])
      this.res=response
      this.viewTicket=true;
      this.reviewTicket=false;
      
    })
  }

//ticketbook
  
tickFare:number=0;

getticketfare(){
      console.log('------>>>>>   '+this.model.passangerList.lenth);
      
      const promise = this.userService.getticketFare(this.model.tickeyType, this.model.flightId, this.model.passangerList);
  promise.subscribe((response:any) => {
    console.log(response);

    // this.router.navigate(['/ticketSuccess'])
    this.model.ticketFare=response.ticketFare;
    console.log(this.model.ticketFare);
    
 this.tickFare=response.ticketFare;
    
  })
}


  
  returnhome(){
    this.router.navigate(['searchflight']);
  }

}
