import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-viewticket',
  templateUrl: './viewticket.component.html',
  styleUrls: ['./viewticket.component.css']
})
export class ViewticketComponent implements OnInit {

  constructor(private userService: UserServiceService) { }

  userEmail: string = "";
  searchMode: string = "";
  errorWindow: boolean = false;
  showticketWindow: boolean = false;
  userEmailDetails: boolean = false;
  resultdata: any
  ticketDetails: any
  passangerList: any = []

  ticketDetailsList: any = []


  ngOnInit(): void {
    this.searchMode = "ByEmail";
    this.userEmail = "";
    this.errorWindow = false;
    this.showticketWindow = false;
    this.userEmailDetails = false;
  }


viewTicket(pnrnumber:string){
  const promise = this.userService.searchTicket(pnrnumber, "ByPnrNumber");
  promise.subscribe((res: any) => {
    console.log(res);
    if (!res.status) {
      this.errorWindow = true;
      this.showticketWindow = false;
      this.userEmailDetails = false;

    } else if (res.status) {
      this.errorWindow = false;
      this.showticketWindow = true;
      this.userEmailDetails = false;

      this.ticketDetails = res.ticketBooking
      this.passangerList = res.passangeDetails;
    }
  })
}




  ticketSearch() {
    if (this.userEmail == "") {
      alert('please enter username or pnr number')
    } else {
      console.log(this.userEmail);

      if (this.searchMode == "ByEmail") {
        const promise = this.userService.searchTicketByUserName(this.userEmail);
        promise.subscribe((res: any) => {
          console.log(res);
          this.ticketDetailsList = res;
          this.userEmailDetails = true;
          this.showticketWindow = false;
          this.errorWindow = false;


        })
      } else {
        const promise = this.userService.searchTicket(this.userEmail, this.searchMode);
        promise.subscribe((res: any) => {
          console.log(res);
          if (!res.status) {
            this.errorWindow = true;
            this.showticketWindow = false;
            this.userEmailDetails = false;

          } else if (res.status) {
            this.errorWindow = false;
            this.showticketWindow = true;
            this.userEmailDetails = false;

            this.ticketDetails = res.ticketBooking
            this.passangerList = res.passangeDetails;
          }
        })
      }

    }
  }

}
