import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from 'src/app/admin-service.service';
import login from '../Model/login';
import OutPutModel from '../Model/OutputModel';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }

  ngOnInit(): void {
  }


  loginObj: login = new login();
  outputModel: OutPutModel = new OutPutModel();


  login() {
    console.log(this.loginObj);
    const promise = this.adminService.login(this.loginObj);
    promise.subscribe((response: any) => {
      console.log(response);
      this.outputModel.message = response.message;
      this.outputModel.status = response.status;
      if (this.outputModel.status) {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/loginsuccess'])
        this.adminService.isUserLoggedIn.next(true);
      }
    })
  }
}
