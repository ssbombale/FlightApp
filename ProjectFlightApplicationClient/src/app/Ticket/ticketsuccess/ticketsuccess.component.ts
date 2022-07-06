import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticketsuccess',
  templateUrl: './ticketsuccess.component.html',
  styleUrls: ['./ticketsuccess.component.css']
})
export class TicketsuccessComponent implements OnInit {

  constructor() { }

  @Input() res: any

  ngOnInit(): void {
    console.log(this.res);
    this.successMsg = true;
    this.viewtickettmsg = false;
  }
  ticketDetails: any
  passangerList: any = []
  successMsg: boolean = false
  viewtickettmsg: boolean = false

  viewTicket() {
    this.successMsg = false;
    this.viewtickettmsg = true;
    this.ticketDetails = this.res.ticketBooking
    this.passangerList = this.res.passangeDetails;
  }

}
