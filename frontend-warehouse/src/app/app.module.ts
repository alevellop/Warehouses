import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { WarehousesListComponent } from './components/warehouses-list/warehouses-list.component';
import {HttpClientModule } from '@angular/common/http';
import { WarehouseCreateComponent } from './components/warehouse-create/warehouse-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WarehouseEditComponent } from './components/warehouse-edit/warehouse-edit.component';
import { WarehouseDetailsComponent } from './components/warehouse-details/warehouse-details.component';
import { PermutationComponent } from './components/permutation/permutation.component';
@NgModule({
  declarations: [
    AppComponent,
    WarehousesListComponent,
    WarehouseCreateComponent,
    WarehouseEditComponent,
    WarehouseDetailsComponent,
    PermutationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
