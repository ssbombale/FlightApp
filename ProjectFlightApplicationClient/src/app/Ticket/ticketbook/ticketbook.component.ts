import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserServiceService } from 'src/app/user-service.service';
import SearchFlightModel from '../Model/SearchFlightModel';

@Component({
  selector: 'app-ticketbook',
  templateUrl: './ticketbook.component.html',
  styleUrls: ['./ticketbook.component.css']
})
export class TicketbookComponent implements OnInit {


  @Input() emp: SearchFlightModel | undefined;

  id: number = 0;

  sss: string = "";

  mealtypearray:any=[]


  booktickWind: boolean = false
  reviewticket: boolean = true

  flightId:any=0;

  searchmode: SearchFlightModel = new SearchFlightModel()
  ngOnInit(): void {

    console.log(this.emp);
    this.booktickWind = true
    this.productForm = this.fb.group({
      flightName: this.emp?.flightName,
      flightCode: this.emp?.flightCode,
      airlineName: this.emp?.airlineName,
      startPoint: this.emp?.startPoint,
      endPoint: this.emp?.endPoint,
      startTime: this.emp?.startTime,
      endTime: this.emp?.endTime,
      searchDate: this.emp?.searchDate,
      userEmail:'',
      tickeyType:'Business',
      flightId:this.emp?.flightId,
      passangerList: this.fb.array([]),
    })
    this.flightId=this.emp?.flightId
    this.addPassanger();
    this.reviewticket = false;
    this.getmealtype();
  }

  productForm: FormGroup;

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private router: Router, private userService:UserServiceService) {

    console.log(this.emp?.flightName);


    this.productForm = this.fb.group({
      flightName: this.emp?.flightName,
      flightCode: this.emp?.flightCode,
      airlineName: '',
      startPoint: '',
      endPoint: '',
      startTime: '',
      endTime: '',
      searchDate: '',
      userEmail: '',
      tickeyType:'',
      flightId:'',
      ticketFare:'',
      passangerList: this.fb.array([]),
    });
  }


  passangerDetails(): FormArray {
    return this.productForm.get("passangerList") as FormArray
  }

  newPassangerList(): FormGroup {
    return this.fb.group({
      passangerName: '',
      gender: 'Male',
      age: 0,
      mealType: 'Veg'
    })
  }

  addPassanger() {
    this.passangerDetails().push(this.newPassangerList());
  }

  removePassanger(i: number) {
    this.passangerDetails().removeAt(i);
  }

  reviewTicket() {
    console.log(this.productForm.value);

    this.booktickWind = false
    this.reviewticket = true
  }

  backtohome() {
    this.router.navigate(['searchflight']);
  }



  getmealtype(){
    const promise = this.userService.getMealType(this.flightId);
    promise.subscribe((response: any) => {
      console.log(response); 
      this.mealtypearray=response   
    })
  }

}
