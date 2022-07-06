import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-cancelticket',
  templateUrl: './cancelticket.component.html',
  styleUrls: ['./cancelticket.component.css']
})
export class CancelticketComponent implements OnInit {


  userEmail: string = "";
  searchMode: string = "";
  errorWindow: boolean = false;
  showticketWindow: boolean = false;


  userEmailDetails: boolean = false;

  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {
    this.userEmail = ""
    this.searchMode = "ByEmail";
    this.errorWindow = false;
    this.showticketWindow = false;
    this.userEmailDetails = false;
  }
  ticketDetailsList: any = []


  cancelTicektByPnr(pnrnumber:string){
    console.log(this.userEmail);
    const promise = this.userService.cancelTicket(pnrnumber, "ByPnrNumber");
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


      }
    })
  }

  cancelTicket() {
    if (this.userEmail == "") {
      alert('please enter username or pnr number')
    } else {

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

        console.log(this.userEmail);
        const promise = this.userService.cancelTicket(this.userEmail, this.searchMode);
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

          }
        })
      }
    }
  }



}
