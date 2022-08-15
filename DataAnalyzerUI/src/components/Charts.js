import React, { useState, useEffect } from 'react'
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import BootstrapTable from 'react-bootstrap-table-next';
import 'bootstrap/dist/css/bootstrap.min.css';
import paginationFactory from 'react-bootstrap-table2-paginator'
import 'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css'


import { Pie } from 'react-chartjs-2';

ChartJS.register(ArcElement, Tooltip, Legend);


const Charts = () => {
  const [chart, setChart] = useState([])
  var baseUrl = "http://192.168.5.55:5402/info/biradsScore";


  const columns = [
    {dataField:'label', text: 'Bi-Rads'},
    {dataField:'datas', text: 'Image Count'},
    
]

const pagination = paginationFactory( {
  page:1,
  sizePerPage: 20,
  lastPageText: '>>',
  firstPageText: '<<',
  nextPageText: '>',
  prePageText:'<',
  showTotal:true,
  alwaysShowAllBtns:true,
  onPageChange: function(page,sizePerPage) {


  },
  onSizePerPageChange: function(page,sizePerPage) {
      console.log('page',page);
      console.log('sizePerPage',sizePerPage);
  }

})

  useEffect(() => {
    const fetchCoins = async () => {
      await fetch("http://192.168.5.55:5402/info/biradsScore")
        .then((response) => {
          if (response.ok) {
            response.json().then((json) => {
              console.log(json);
              setChart(json)
            });
          }
        }).catch((error) => {
          console.log(error);
        });
    };
    fetchCoins()
  }, [baseUrl])

  console.log("chart", chart);
  var data = {
    labels: chart.map(x => x.label),
    datasets: [{
      label: `${chart?.coins?.length} Coins Available`,
      data: chart.map(x => x.datas),
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

  var options = {
    maintainAspectRatio: false,
    scales: {
    },
    legend: {
      labels: {
        fontSize: 10,
      },
    },
  }

  return (
    <div>
      <div className='parent'>
          <div className='child'>
            <Pie
              data={data}
              height={700}
              width={600}
              options={options}
              title="Birads Score"
            />
          </div>
          <div className='child'>
            <BootstrapTable keyField='label' columns={columns} data={chart} pagination={pagination} />
          </div>

          </div>
    </div>
  )
}

export default Charts