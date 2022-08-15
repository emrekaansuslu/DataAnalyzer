import React, { useRef } from "react";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie,Line, Bar, Radar, Doughnut, PolarArea, Bubble, Scatter } from 'react-chartjs-2';
import Chart from 'chart.js/auto';
import 'chart.js/dist/chart'

ChartJS.register(ArcElement, Tooltip, Legend);
const GenericChart = (props) => {


     const data = {
        labels: props.dataList.map(x => x.label),
        datasets: [{
          label: props.chartType,
          data: props.dataList.map(x => x.datas),
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
          
        }]
      };
    
      const options = {
        maintainAspectRatio: false,
        scales: {
        },
        legend: {
          labels: {
            fontSize: 10,
          },
        },
      }

            switch(props.chartType) {
                case "line":
                    return (
                      <div id="chart">
                        <Line
                        data= {data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
                case "pie":
                    return (
                      <div id="chart">
                        <Pie
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
                case "bar":
                    return (
                      <div id="chart">
                        <Bar
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
                case "doughnut":
                    return (
                      <div id="chart">
                        <Doughnut
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
                case "polar area":
                    return (
                      <div id="chart">
                        <PolarArea
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
                case "bubble":
                    return (
                      <div id="chart">
                        <Bubble
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    />
                    </div> )
                    break;
                case "scatter":
                    return (
                      <div id="chart">
                        <Scatter
                        data={data}
                        height={700}
                        width={600}
                        options={options}
                        title="Number of Images"
                    /> 
                    </div>)
                    break;
            }

  
}

export default GenericChart