const getProducts = async () => {
    const response = await fetch("/api/wines")
    if(response.ok) {
        return await response.json()
    }

    return []
}

const PRODUCT_TEMPLATE = `
        <div class="shop-product-box text-center">
            <div class="product-box-shape">
                <img alt="Product Box Shape" src="assets/images/product-box-shape.png">
            </div>
            <div class="shop-product-box-img">
                <a href="product-single.html" title="Wine Bottle">
                    <img alt="Wine Bottle" src="assets/images/wine-bottle-WINE_INDEX.png">
                </a>
            </div>
            <div class="shop-product-box-info">
                <span class="posted_in">WINE_APPELLATION</span>
                <span class="posted_in">WINE_REGION</span>
                <a class="product-name title-divider" href="product-single.html">WINE_NAME</a>
                <h4 class="product-box-price">
                    WINE_PRICE€
                </h4>
            </div>
        </div>`

getProducts().then(wines => {
     // On récupère le container des produits
     const products = document.getElementById("products");
     // On créer un produit via son template en fonction de ce que nous retourne l'API
     wines.forEach(({ name, estate, price, appellation, region }) => {
           const imageIndex = Math.floor(Math.random() * 6) + 1;
           const div = document.createElement('div');
           div.classList.add('col-lg-4');
           div.classList.add('col-sm-6');
           div.innerHTML = PRODUCT_TEMPLATE
                    .replace('WINE_NAME', name)
                    .replace('WINE_PRICE', price)
                    .replace('WINE_APPELLATION', appellation)
                    .replace('WINE_REGION', region)
                    .replace('WINE_INDEX', imageIndex);
           const child = products.appendChild(div);
     })
})