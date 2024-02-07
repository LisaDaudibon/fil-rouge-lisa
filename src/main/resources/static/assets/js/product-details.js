const PRODUCT_DETAILS_TEMPLATE = `
            <div class="col-lg-6">
                <div class="product-left">
                    <div style="width: 660px;">
                        <img alt="Product Image" src="assets/images/wine-bottle-WINE_INDEX.png">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product-info">
                    <div class="breadcrumb-wp">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html" title="Home">produits</a></li>
                            <li class="breadcrumb-item active">WINE_APPELLATION</li>
                        </ul>
                    </div>
                    <h1 class="h1-title">WINE_NAME</h1>
                    <span class="posted_in">Catégorie: WINE_REGION</span>
                    <h3 class="product-price">WINE_PRICE€</h3>
                    <p>WINE_DESCRIPTION</p>
                    <div class="product-short-description">
                        <h3 class="title-divider">Fiche technique</h3>
                        <ul>
                            <li><b>Année:</b> WINE_YEAR</li>
                            <li><b>Couleur:</b> WINE_COLOR</li>
                            <li><b>Degré d'alcool:</b> WINE_ALCOHOL_POURCENTAGE</li>
                            <li><b>Cépage(s):</b>WINE_GRAPE_VARIETIES</li>
                            <li><b>Région:</b> WINE_REGION</li>
                        </ul>
                    </div>
                </div>
            </div>`

const getProductById = async (id) => {
    const response = await fetch("/api/wines/" + id)
    if (response.ok) {
        return await response.json()
    }

    return []
}

getProductById(1).then(({ name, estate, price, description, appellation, region, year, color, grapeVarieties, alcoholPercentage }) => {
    // On récupère le container des produits
    const products = document.getElementById("product");
    // On créer un produit via son template en fonction de ce que nous retourne l'API
    const imageIndex = Math.floor(Math.random() * 6) + 1;
    const div = document.createElement('div');
    div.classList.add('row');
    div.innerHTML = PRODUCT_DETAILS_TEMPLATE
        .replace('WINE_NAME', name + (estate ? ' - ' + estate : ''))
        .replace('WINE_PRICE', price)
        .replace('WINE_YEAR', year)
        .replace('WINE_COLOR', color)
        .replace('WINE_ALCOHOL_POURCENTAGE', alcoholPercentage)
        .replace('WINE_GRAPE_VARIETIES', grapeVarieties)
        .replaceAll('WINE_APPELLATION', appellation)
        .replace('WINE_DESCRIPTION', description ?? 'Aucune description')
        .replaceAll('WINE_REGION', region)
        .replace('WINE_INDEX', imageIndex);
    const child = products.appendChild(div);
})