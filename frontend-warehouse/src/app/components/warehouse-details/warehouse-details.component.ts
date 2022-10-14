import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rack } from 'src/app/models/rack.model';
import { Warehouse } from 'src/app/models/warehouse.model';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-details',
  templateUrl: './warehouse-details.component.html',
  styleUrls: ['./warehouse-details.component.css']
})
export class WarehouseDetailsComponent implements OnInit {

  id: number;
  warehouse: Warehouse;
  racks: Rack[];

  constructor(
    private route: ActivatedRoute,
    private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.warehouse = new Warehouse();
    this.warehouseService.getById(this.id).subscribe({
      next: (data) => {
        this.warehouse = data;
        console.log(data.racks);
        this.racks = data.racks
      },
      error: (e) => console.log(e)
    });
  }

}
