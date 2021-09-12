import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar

    //Hook
    //useState eh constante por isso nao preciso usar let, o dado contido nele pode mudar, mas o useState eh o mesmo para todo ciclo de vida
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });


    //chamada do axios tem que ser feita uma unica vez quando o componente for instanciado
    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(reponse => {
                const data = reponse.data as SaleSum[]; //casting, pra acessar cada um dos objetos que veio na reponse
                const myLabels = data.map(x => x.sellerName); //criando nova lista chamada myLabels
                const mySeries = data.map(x => x.sum);

                setChartData({ labels: myLabels, series: mySeries }); //passando como argumento o novo objeto que montei com os dados da API
            });
    }, []); //seg param lista de objetos que o useEffect vai observar



    //FORMA ERRADA, declarar variavel, o correto eh usar hooks, entre outros recursos
    //criando variavel chartData do tipo ChartData e instanciando ela com valores de labels e series vazios
    //let chartData : ChartData = { labels: [], series: [] }; 

    /*const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }*/

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            //xaxis eh o eixo x
            //funcao options sendo passada para o argumento options do Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        /> //retornando componente jsx
    );
}

export default DonutChart;