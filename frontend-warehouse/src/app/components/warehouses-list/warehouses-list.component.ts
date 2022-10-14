import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Warehouse } from 'src/app/models/warehouse.model';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouses-list',
  templateUrl: './warehouses-list.component.html',
  styleUrls: ['./warehouses-list.component.css']
})
export class WarehousesListComponent implements OnInit {

  warehouses: Warehouse[];

  constructor(
    private warehouseService: WarehouseService,
    private router: Router) { }

  ngOnInit(): void {
    this.getWarehouses();
  }

  editWarehouse(id: number){
    this.router.navigate(['warehouses/' + id + '/edit']);
  }

  deleteWarehouse(id: number){
    this.warehouseService.delete(id).subscribe({
      next: (data) => {
        this.getWarehouses();
        alert("Warehouse deleted succesfully!")
      },
      error: (e) => console.log(e)
    });
  }
  viewWarehouse(id: number){
    this.router.navigate(['warehouses/', id]);
  }

  private getWarehouses(){
    this.warehouseService.getAll().subscribe({
      next: (data) => this.warehouses = data,
      error: (e) => console.log(e)
    });
  }

}
