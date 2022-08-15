import BootstrapTable from 'react-bootstrap-table-next';
import 'bootstrap/dist/css/bootstrap.min.css';
import paginationFactory from 'react-bootstrap-table2-paginator'
import 'react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css'


const MidasTable = (props) => {


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

      
  const columns = [
    {dataField:'label', text: props.axisName},
    {dataField:'datas', text: 'Image Count'},
    
]


      return(   
         <div className='child'>
                <BootstrapTable keyField='label' columns={columns} data={props.tableData} pagination={pagination} />
        </div>
      )


}

export default MidasTable