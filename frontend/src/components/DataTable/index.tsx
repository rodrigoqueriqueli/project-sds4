import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar

    const [page, setPage] = useState<SalePage>({ //passando todos os campos que sao obrigatorios
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    //useEffect pra fazer leitura da API apenas uma vez, quando a pagina carregar
    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=0&size=20&sort=date,desc`)
            .then(reponse => {
                setPage(reponse.data);//passo response (corpo da api para funcao do setPage)..pego o corpo da resposta e jogo no Page
            });//then sera executado se requisicao retornar 200, ai entao eu faço
    }, []); //lista vazia significa que ninguem esta sendo observado ainda

    return (
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
    );
}

export default DataTable;

function formatLocalData(date: string, arg1: string): import("react").ReactNode {
    throw new Error("Function not implemented.");
}
