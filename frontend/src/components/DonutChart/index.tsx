import Chart from 'react-apexcharts';

const DonutChart = () => { //criando componente NavBar...funcao anonima sendo atribuida a variavel NavBar
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }
    
    return (
        <Chart 
            //xaxis eh o eixo x
            //funcao options sendo passada para o argumento options do Chart
            options={{...options, labels: mockData.labels}}
            series={mockData.series}
            type="donut"
            height="240"
        /> //retornando componente jsx
    );
}

export default DonutChart;