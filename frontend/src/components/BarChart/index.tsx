import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels:{
        categories: string[];   //tipo desse label eh um objeto categories
    };
    series: SeriesData[];
}

const BarChart = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []                   
            }
        ]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then(reponse => {
                const data = reponse.data as SaleSuccess[]; //casting, pra acessar cada um dos objetos que veio na reponse
                const myLabels = data.map(x => x.sellerName); //criando nova lista chamada myLabels
                const mySeries = data.map(x => round(100.0 * (x.deals / x.visited), 1));

                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "Success %",
                            data: mySeries                   
                        }
                    ]
                }); //passando como argumento o novo objeto que montei com os dados da API
            });
    }, []); //seg param lista de objetos que o useEffect vai observar

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    // const mockData = {
    //     labels: {
    //         categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //     },
    //     series: [
    //         {
    //             name: "% Sucesso",
    //             data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
    //         }
    //     ]
    // };
    
    return (
        <Chart 
            //xaxis eh o eixo x
            //funcao options sendo passada para o argumento options do Chart
            options={{...options, xaxis: chartData.labels}}
            series={chartData.series}
            type="bar"
            height="240"
        /> //retornando componente jsx
    );
}

export default BarChart;