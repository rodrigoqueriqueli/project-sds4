import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar

    const [activePage, setActivePage] = useState(0);

    const [page, setPage] = useState<SalePage>({ //passando todos os campos que sao obrigatorios
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    //useEffect pra fazer leitura da API apenas uma vez, quando a pagina carregar
    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
            .then(reponse => {
                setPage(reponse.data);//passo response (corpo da api para funcao do setPage)..pego o corpo da resposta e jogo no Page
            });//then sera executado se requisicao retornar 200, ai entao eu faço
    }, [activePage]); //lista vazia significa que ninguem esta sendo observado ainda..sempre que o activePage mudar ele vai executar o axios de novo

    const changePage = (index: number) => {
        setActivePage(index); //a pagina ativa sera o indice passado no parametro do setActivePage
    }


    return (
        <>
            <Pagination page={page} onPageChange={changePage}/> 
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Seller</th>
                            <th>Visited clients</th>
                            <th>Sales</th>
                            <th>Price</th>
                        </tr>
                    </thead>

                    <tbody>
                        { //meu objeto page..campo content eh a lista 
                            page.content?.map(item => (
                                <tr key={item.id}>
                                    <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                    <td>{item.seller.name}</td>
                                    <td>{item.visited}</td>
                                    <td>{item.deals}</td>
                                    <td>{item.amount.toFixed(2)}</td>
                                </tr>
                            ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;

