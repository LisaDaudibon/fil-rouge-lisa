const getProducts = async () => {
    const response = await fetch("/api/wines")
    if (response.ok) {
        return await response.json()
    }

    return []
}

const PRODUCT_SWIPER_TEMPLATE = `
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="banner-text">
                                <h3 class="sub-title h3-title">WINE_APPELLATION</h3>
                                <h3 class="sub-title h3-title">WINE_REGION</h3>
                                <h1 class="h1-title">WINE_NAME</h1>
                                <div class="banner-btn">
                                    <a class="select-btn" href="product-single.html" title="Voir le produit">Voir
                                        le produit
                                    </a>
                                    <h3 class="banner-bottle-price">
                                        WINE_PRICE€
                                        <span class="underline-text"></span>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="banner-right-part">
                                <div class="wine-bottle">
                                    <img alt="" src="assets/images/wine-bottle-WINE_INDEX.png">
                                </div>
                            </div>
                        </div>
                    </div>`

getProducts().then(wines => {
    // On récupère le container des produits
    const products = document.getElementById("swiper-container");
    // On créer un produit via son template en fonction de ce que nous retourne l'API
    for (let i = 0; i < 2; i++) {
        const { name, estate, price, appellation, region } = wines[i]
        const imageIndex = Math.floor(Math.random() * 6) + 1;
        const div = document.createElement('div');
        div.classList.add('swiper-slide');
        div.innerHTML = PRODUCT_SWIPER_TEMPLATE
            .replace('WINE_NAME', name + (estate ? ' - ' + estate : ''))
            .replace('WINE_PRICE', price)
            .replace('WINE_APPELLATION', appellation)
            .replace('WINE_REGION', region)
            .replace('WINE_INDEX', imageIndex);
        const child = products.appendChild(div);
    }

    new Swiper(".banner_slider", {
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
    });
})