window.onload = () => {
    document.getElementById("search-button").addEventListener('click', () => {
        document.getElementById("search-form-wp").classList.toggle("open-search-form")
    })

    document.getElementById("close-button").addEventListener('click', () => {
        document.getElementById("search-form-wp").classList.toggle("open-search-form")
    })

    document.getElementById("menu-toggle").addEventListener('click', () => {
        document.getElementById("main-navigation").classList.toggle("toggled")
        document.getElementById("site-header").classList.toggle("header-toggled")
    })

    document.getElementById("scrollToTop").addEventListener('click', () => {
        document.getElementsByTagName('html')[0].scrollTo({ top: 0 })
    })
};
