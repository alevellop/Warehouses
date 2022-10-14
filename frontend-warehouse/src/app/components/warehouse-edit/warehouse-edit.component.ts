import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Rack } from 'src/app/models/rack.model';
import { Warehouse } from 'src/app/models/warehouse.model';
import { RackService } from 'src/app/services/rack.service';
import { RacksTypeService } from 'src/app/services/racks-type.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-edit',
  templateUrl: './warehouse-edit.component.html',
  styleUrls: ['./warehouse-edit.component.css']
})
export class WarehouseEditComponent implements OnInit {

  id: number;
  warehouse: Warehouse = new Warehouse();
  warehouseFamilies: string[];
  racks: Rack[];
  editForm: FormGroup = new FormGroup({
    uui: new FormControl(''),
    client: new FormControl(''),
    family: new FormControl(''),
    size: new FormControl(''),
  });
  submitted: boolean = false;

  constructor(
    private warehouseService: WarehouseService,
    private racksTypeService: RacksTypeService,
    private rackService: RackService,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getWarehouse(this.id);
    this.getWarehouseFamilies();
    this.submitted = false;

    this.editForm = this.formBuilder.group({
      uuid: new FormControl(""),
      client: new FormControl(""),
      family: new FormControl(""),
      size: new FormControl("", Validators.pattern(/^-?(0|[1-9]\d*)?$/))
    });

    setTimeout(() => {
      this.editForm.setValue(this.warehouse);
    }, 0);
  }

  onSubmit(){
    this.submitted = true;
    this.editWarehouse();
  }

  editWarehouse(){
    this.warehouseService.update(this.id, this.editForm.value).subscribe({
      next: (data) => {
        alert("Warehouse updated succesfully!");
        this.backIndex()
      },
      error: (e) => console.log(e)
    });
  }

  getWarehouse(id: number){
    this.warehouseService.getById(this.id).subscribe({
      next: (data) => {
        this.warehouse.uuid =  data.uuid;
        this.warehouse.client = data.client;
        this.warehouse.family = data.family;
        this.warehouse.size = data.size;
        this.racks = data.racks;
      },
      error: (e) => console.error(e)
    });
  }

  getRacks(warehouseId: number){
    this.rackService.getAllRacksByWarehouse(warehouseId).subscribe({
      next: (data) => this.racks = data,
      error: (e) => console.log(e)
    });
  }

  getWarehouseFamilies(){
    this.racksTypeService.getAllFamilies().subscribe({
      next: (data) => this.warehouseFamilies = data,
      error: (e) => console.log(e)
    });
  }

  deleteRack(rackId: number){
    this.rackService.deleteRack(rackId).subscribe({
      next: (data) => {
        this.getRacks(this.warehouse.id);
        this.router.navigate(['edit']);
        alert("Warehouse deleted succesfully!")
      },
      error: (e) => console.log(e)
    });
  }

  //short name for variables in HTML template
  get f(): { [key: string]: AbstractControl }{
    return this.editForm.controls;
  }
  backIndex(){
    this.router.navigate(['']);
  }

}
