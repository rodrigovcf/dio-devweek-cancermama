import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatSortModule} from '@angular/material/sort';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';


import { OcorrenciasRoutingModule } from './ocorrencias-routing.module';
import { OcorrenciasComponent } from './ocorrencias/ocorrencias.component';



@NgModule({
  declarations: [
    OcorrenciasComponent
  ],
  
  imports: [
    CommonModule,
    OcorrenciasRoutingModule,
    MatSortModule,
    MatCardModule,
    HttpClientModule
  ]
})
export class OcorrenciasModule { }
