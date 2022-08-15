import React, {useState, useEffect} from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import 'bootstrap/dist/css/bootstrap.min.css';
import paginationFactory from 'react-bootstrap-table2-paginator'
import 'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css'
import filterFactory, {textFilter,numberFilter,dateFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import {ThreeDots} from 'react-loader-spinner';

function StatusInfoList() {

    const[statusInfoList, setStatusInfoList] = useState([]);
    const [loading, setLoading] = useState(false);


    

    const columns = [
        {dataField:'patientID', text: 'Patient ID'},
        {dataField:'date', text: 'Date'},
        {dataField:'status', text: 'Status'},
        {dataField:'imageCount', text: 'Image #'},
        {dataField:'biradsScore',text:'Birads Score', filter:textFilter()},
        {dataField:'bilateralScore',text:'Bilateral Soore', filter:textFilter()},
        {dataField:'leftIntensity',text:'Left Int.',filter:textFilter()},
        {dataField:'rightIntensity',text:'Right Int.',filter:textFilter()},
        {dataField:'microCalcScore',text:'MicroCalc Score',filter:textFilter()},
        {dataField:'macroCalcScore',text:'MacroCalc Score',filter:textFilter()}
        
        
    ]

    const getQuery = (_page,_size) => {
        console.log("HEREEE")
        var url = 'http://192.168.5.55:5402/info/getAll?'
        url = url+'page='+_page+'&';
        url = url+'size='+_size+'';

        fetch(url)
        .then(response => response.json())
        .then(result => setStatusInfoList(result["tutorials"]))
        .catch(error => console.log(error));

    }
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
        setLoading(true);
        fetch('http://192.168.5.55:5402/info/getAll')
        .then(response => response.json())
        .then(result => setStatusInfoList(result))
        .catch(error => console.log(error))
        .finally(()=> setLoading(false));
    },[]);

    if(loading) {
        return (<ThreeDots/>)
    } else {
    return (
        <BootstrapTable keyField='id' columns={columns} data={statusInfoList} pagination={pagination} filter={filterFactory()}/>
      )
    }
}

export default StatusInfoList;