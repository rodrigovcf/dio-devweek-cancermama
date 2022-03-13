import { Component, OnInit } from '@angular/core';
import { Faixaetaria } from '../model/Faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  ocorrencia_exame: Ocorrencia[] = [];
  regioes: Regiao[] = [];
  faixaetarias: Faixaetaria[] = [];

  constructor(
    private ocorrenciaService: OcorrenciaService,
    private regioesService: RegiaoService,
    private faixaEtariaService: FaixaetariaService
  ) { }
  ngOnInit(): void {
    this.regioesService.listRegioes().subscribe(regioes => {this.regioes = regioes});
    // this.ocorrencia_exame = this.ocorrenciaService.listOcorrencias(); 
    
    this.ocorrenciaService.listOcorrencias().subscribe(ocorrencia_exame => {this.ocorrencia_exame = ocorrencia_exame})

    this.faixaEtariaService.listFaixaEtaria().subscribe(faixaetarias => {this.faixaetarias = faixaetarias})    
  }

}
