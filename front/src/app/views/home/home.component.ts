import { Component, OnInit } from '@angular/core';
import { Wine } from '../../model/wine';
import { WinesService } from '../../services/wines.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  $fetchedWines: Observable<Wine[]>

  constructor( private _wineService: WinesService) {
    this.$fetchedWines = this._wineService.$fetchWines
  }

  trackByWineId(index: number, wine: Wine):number { return wine.id }

  ngOnInit() {
    new (window as any).Swiper(".banner_slider", {
      slidesPerView: 1,
      spaceBetween: 0,
      grabCursor: true,
      autoplay: {
        delay: 3000,
        disableOnInteraction: false,
      },
      speed: 3000,
      effect: "creative",
      creativeEffect: {
        prev: {
          translate: ["-120%", 0, -500],
          opacity: 0,
        },
        next: {
          translate: ["120%", 0, -500],
          opacity: 0,
        },
      },
    })
  }

}
