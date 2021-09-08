
const Footer = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar
    return (
        <footer className="footer mt-auto py-3 bg-dark">
            <div className="container">
                <p className="text-light">App developed by <a href="https://github.com/rodrigoqueriqueli" target="_blank" rel="noreferrer">Rodrigo Queriqueli</a></p>
                <p className="text-light"><small><strong>Spring React Week</strong><br />
                    Event promoted by DevSuperior school: <a href="https://instagram.com/devsuperior.ig" target="_blank" rel="noreferrer">@devsuperior.ig</a></small></p>
            </div>
        </footer>
    );
}

export default Footer;