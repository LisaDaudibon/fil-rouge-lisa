import { Component, Input } from '@angular/core';
import { Wine } from '../../model/wine';


@Component({
  selector: 'app-wine',
  templateUrl: './wine.component.html',

})
export class WineComponent {
  @Input({ required: true}) data!: Wine;

  async getProducts(): Promise<Wine[]> {
    const response = await fetch(`api/wines`)
    if(response.ok) {
        return await response.json()
    }

    return []
  }



  // @Input({required: true}) data!: Wine;

  ngOnInit ():void {
    
    // this.getProducts().then(wines => {
    //   // On récupère le container des produits
    //   const products = document.getElementById("swiper-container")!;
    //   // On créer un produit via son template en fonction de ce que nous retourne l'API
    //   for (let i = 0; i < 2; i++) {
    //     const { name, estate, price, appellation, region } = wines[i]
    //     const imageIndex = Math.floor(Math.random() * 6) + 1;
    //     const div = document.createElement('div');
    //     div.classList.add('swiper-slide');
    //     div.innerHTML = PRODUCT_SWIPER_TEMPLATE
    //       .replace('WINE_NAME', name + (estate ? ' - ' + estate : ''))
    //       .replace('WINE_PRICE', price.toString())
    //       .replace('WINE_APPELLATION', appellation)
    //       .replace('WINE_REGION', region)
    //       .replace('WINE_INDEX', imageIndex.toString());
    //     const child = products.appendChild(div);
    // }
  // })

    
  }
}
