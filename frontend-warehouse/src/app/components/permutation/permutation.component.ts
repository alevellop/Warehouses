import { Component, OnInit } from '@angular/core';
import { Permutation } from 'src/app/models/permutation.model';
import { PermutationService } from 'src/app/services/permutation.service';

@Component({
  selector: 'app-permutation',
  templateUrl: './permutation.component.html',
  styleUrls: ['./permutation.component.css']
})
export class PermutationComponent implements OnInit {

  permutations: Permutation[];

  constructor(private permutationService: PermutationService) { }

  ngOnInit(): void {
    this.getPermutations();
  }

  getPermutations(){
    this.permutationService.getAll().subscribe({
      next: (data) => {
        console.warn(data);
        this.permutations = data
      },
      error: (e) => console.log(e)
    });

  }

}
