import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { MyDiagnosticCentre } from './mydiagnosticcentre';
import { MydiagnosticcentreService } from './mydiagnosticcentre.service';
import { Router } from '@angular/router';
import { MyTest } from '../mytest/mytest';

@Component({
  selector: 'app-mydiagnosticcentre',
  templateUrl: './mydiagnosticcentre.component.html',
  styleUrls: ['./mydiagnosticcentre.component.css']
})
export class MydiagnosticcentreComponent implements OnInit {
  diagnosticCentre:Observable<MyDiagnosticCentre[]>
  test: MyTest;
  constructor(private service: MydiagnosticcentreService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.diagnosticCentre=this.service.getDiagnosticCentreList();
  }

  deleteDiagnosticCentre(id: number){
    this.service.removeDiagnosticCentre(id).subscribe(
      data=>{
        console.log(data);
        this.reloadData();
      },
      error=>console.log(error)
    );
  }

  diagnosticCentreDetail(id: number){
    this.router.navigate(['diagnosticCentreDetail',id]);

  }

  updateDiagnosticCentre(id: number){
    this.router.navigate(['updateDiagnosticCentre',id]);

  }
  addTestIntoExistingDiagnosticCentre(id: Number){
    this.router.navigate(['addTestInCentre',id]);
  }
}
