import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from 'src/app/admin-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  token = localStorage.getItem('token')

  isUserLoggedIn: boolean=false;
  constructor(private adminService:AdminServiceService) { 

   this.adminService.isUserLoggedIn.subscribe( value => {
      this.isUserLoggedIn = value;
  });

  }

  ngOnInit(): void {
    console.log(this.token);
    if(this.token!=null)
    {
      this.adminService.isUserLoggedIn.next(true);
    }else{
      this.adminService.isUserLoggedIn.next(false);
    }
  }


  logout(){
    localStorage.removeItem('token');
  }


}
