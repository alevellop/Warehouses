import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PermutationComponent } from './components/permutation/permutation.component';
import { WarehouseCreateComponent } from './components/warehouse-create/warehouse-create.component';
import { WarehouseDetailsComponent } from './components/warehouse-details/warehouse-details.component';
import { WarehouseEditComponent } from './components/warehouse-edit/warehouse-edit.component';
import { WarehousesListComponent } from './components/warehouses-list/warehouses-list.component';

const routes: Routes = [
  { path: 'warehouses', component: WarehousesListComponent },
  { path: '', redirectTo: 'warehouses', pathMatch: 'full' },
  { path: 'warehouses/create', component: WarehouseCreateComponent },
  { path: 'warehouses/:id/edit', component: WarehouseEditComponent},
  { path: 'warehouses/:id', component: WarehouseDetailsComponent},
  { path: 'permutations', component: PermutationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
