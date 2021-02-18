import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceEmployeeService } from '../service-employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  employee:Employee = new Employee();

  emailId: string='';
   

  constructor(private employeeService:ServiceEmployeeService,private router:Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
   
  }

  onSubmit()
  {
    this.emailId = this.route.snapshot.params['emailId'];
     
     
     
    this.employeeService.getEmployeeByemailId(this.emailId).subscribe(data=>
      {
        console.log(data);
        this.employee=data;
        console.log(this.employee);
      },error=>console.log(error));
      
    
  }

  
  

}
