import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Warehouse } from 'src/app/models/warehouse.model';
import { RacksTypeService } from 'src/app/services/racks-type.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-create',
  templateUrl: './warehouse-create.component.html',
  styleUrls: ['./warehouse-create.component.css']
})
export class WarehouseCreateComponent implements OnInit {

  createForm: FormGroup;
  submitted: boolean = false;
  warehouseFamilies: string[];

  constructor(
    private warehouseService: WarehouseService,
    private racksTypeService: RacksTypeService,
    private formBuilder: FormBuilder,
    private router: Router) {
    }

  ngOnInit(): void {
    this.getWarehouseFamilies();
    this.submitted = false;

    this.createForm = this.formBuilder.group({
      uuid: new FormControl("", Validators.required),
      client: new FormControl("", Validators.required),
      family: new FormControl("", Validators.required),
      size: new FormControl("", [
        Validators.required,
        Validators.pattern(/^-?(0|[1-9]\d*)?$/)])
    });
  }

  onSubmit(){
    this.submitted = true;
    this.createWarehouse();
  }

  createWarehouse(){
    this.warehouseService.create(this.createForm.value).subscribe({
      next: (data) => {
        alert("Warehouse created succesfully!");
        this.backIndex()
      },
      error: (e) => console.log(e)
    });
  }

  getWarehouseFamilies(){
    this.racksTypeService.getAllFamilies().subscribe({
      next: (data) => this.warehouseFamilies = data,
      error: (e) => console.log(e)
    });
  }

  // shorted name for variables in HTML template
  get f(): { [key: string]: AbstractControl} {
    return this.createForm.controls;
  }

  backIndex(){
    this.router.navigate(['']);
  }
}
