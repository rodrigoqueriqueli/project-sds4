import Chart from 'react-apexcharts';

const BarChart = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
            }
        ]
    };
    
    return (
        <Chart 
            //xaxis eh o eixo x
            //funcao options sendo passada para o argumento options do Chart
            options={{...options, xaxis: mockData.labels}}
            series={mockData.series}
            type="bar"
            height="240"
        /> //retornando componente jsx
    );
}

export default BarChart;