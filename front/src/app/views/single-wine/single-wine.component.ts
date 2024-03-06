import { Component } from '@angular/core';
import { WinesService } from '../../services/wines.service';
import { Wine } from '../../model/wine';

@Component({
  selector: 'app-single-wine',
  templateUrl: './single-wine.component.html',
  styleUrl: './single-wine.component.css'
})
export class SingleWineComponent {
  // private _wine: Wine = ["", "", "", "", 0, 0, "", "", "", { name:"", percentage:""}]

  constructor(private _wineService: WinesService) {
  }

  // wine (id:number): Wine { return this._wineService.getWineById(id).subscribe((wine) => )}
}
