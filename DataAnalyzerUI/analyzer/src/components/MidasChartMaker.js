import React,{Component}  from 'react'
import { Col, Container, ListGroup, Row } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios'
import GenericChart from './GenericChart';
import MidasTable from './MidasTable'


export default class MidasChartMaker extends Component {


    state= {
        currentFieldName: "patientID",
        currentQueryText: "",
        filterList: [],
        showingList: '',
        axis:'patientID',
        chartType:'Line',
        chartData: [],
        chart: '',

    };
    

    comboboxItems = {
    items:[
        "patientID",
        "date",
        "status",
        "imageCount",
        "biradsScore",
        "bilateralScore",
        "leftIntensity",
        "rightIntensity",
        "microCalcScore",
        "macroCalcScore"
    ],
    chartTypes:[
        "Line",
        "Pie",
        "Bar",
        "Doughnut",
        "Polar Area",
        "Bubble",
        "Scatter"

    ]

};
    


    componentDidMount() {

    }

    onClickDrawChart(event) {
        const data = {
             list:this.state.filterList,
             axis:this.state.axis
            };
        const fectFilteredData = async () => {
        await fetch("http://192.168.5.55:5402/info/filteredInfoList", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',

            },
            body: JSON.stringify(data),
        }).then((response)=> {
            if(response.ok) {
                response.json().then((json) => {
                    this.setState({
                        chartData:json
                    });
                });
            }
            
        }).catch((error) => {
            console.log(error)
        });
    };
    fectFilteredData();
    if(this.state.chartData.length > 0) {
     this.drawChart();
    }
    }

    onChangeField(event) {
        this.setState( {currentFieldName:event.target.value});
    }

    onChangeAxis(event) {
        this.setState( {axis:event.target.value});
    }

    onChangeChartType(event) {
        this.setState( {chartType:event.target.value});
    }

    onChangeQueryText(event) {
        this.setState( {currentQueryText: event.target.value});
    }

    onClickAddButton() {
        let currentFiled = this.state.currentFieldName;
        let currentQuery =  this.state.currentQueryText;
        { 
            if(this.state.currentQueryText.length != 0) {
                const index = this.state.filterList.findIndex(x => x.fieldName === currentFiled)
                if(index !== -1) {
                    this.state.filterList.splice(index,1);
                } 
                var newFilter = { fieldName : currentFiled, queryText: currentQuery};
                this.state.filterList.push(newFilter);
                
            }
        }
        this.drawFilterList();
    }

    deleteItemFromList(name) {
        const index = this.state.filterList.findIndex(x => x.fieldName === name)
        if(index !== -1) {
            this.state.filterList.splice(index,1);
        } 
        this.drawFilterList();
    }

    drawFilterList() {
        this.setState({ showingList:
            <ul class="list-group">
                {this.state.filterList.map(filter => (
                        <li class="list-group-item">
                        <span class="name">Filter Field : {filter.fieldName} - Filter Query : {filter.queryText}    </span>
                        <span class="glyphicon glyphicon-remove"></span>
                            <button class="btn btn-default btn-xs pull-right remove-item" onClick={() => this.deleteItemFromList(filter.fieldName)}>
                                Delete
                       
                    </button>
                    </li>
                ))}

          </ul>
        
        })
    }

    drawChart() {
        console.log("dATA" + this.state.chartData)
        if(this.state.chartData.length > 0) {
        this.setState({ chart:
            <Container>
                <Row>
                    <Col>
                        <GenericChart dataList={this.state.chartData} chartType={this.state.chartType.toLocaleLowerCase('en-US')}  xAxisName={this.state.axis}/>
                    </Col>
                    <Col>
                        <MidasTable tableData={this.state.chartData} axisName={this.state.axis} />
                    </Col>
                </Row>
        </Container>
    })
}
    }



     handleRemoveItem = (e) => {
        const name = e.target.getAttribute("fieldName")
        console.log(name);
       };

    render() {
        return ( 
            <React.Fragment>
            <Container>
                <Row >
                <span className="optionalSubstring">Query Filter Section</span> <br />
                    <Col>
                        <select className="form-select form-select-lg mb-3" aria-label=".form-select-lg example" onChange={this.onChangeField.bind(this)}>
                            {this.comboboxItems.items.map(data =>(
                            <option value={data}> {data}</option>
                            ))}
                        </select>
                    </Col>
                    <Col>
                        <input type="text" className="form-control form-control-lg mb-3 "  id="formGroupExampleInput"   onChange={this.onChangeQueryText.bind(this)} />
                    </Col>
                    <Col>
                        <button type='submit' className="btn btn-secondary btn-lg" onClick={this.onClickAddButton.bind(this)}>Add Filter</button>
                    </Col>
                </Row>
                <Row>
                {this.state.showingList} 
                <hr/>
                </Row>
                <Row>
                <span className="optionalSubstring">Chart Properties</span> <br />
                    <Col>
                <select className="form-select form-select-lg mb-3" aria-label=".form-select-lg example" onChange={this.onChangeAxis.bind(this)}>
                            {this.comboboxItems.items.map(data =>(
                            <option value={data}> {data}</option>
                            ))}
                        </select>
                    </Col>

                    <Col>
                <select className="form-select form-select-lg mb-3" aria-label=".form-select-lg example" onChange={this.onChangeChartType.bind(this)}>
                            {this.comboboxItems.chartTypes.map(data =>(
                            <option value={data}> {data}</option>
                            ))}
                        </select>
                    </Col>
                    <Col>
                    <button type='submit' className="btn btn-secondary btn-lg" onClick={this.onClickDrawChart.bind(this)}>Draw Chart</button>      
                    </Col>

                </Row>
                <Row>
                <span className="optionalSubstring">Chart</span> <br />
                </Row>
                <Row>
                    {this.state.chart}
                    
                    
                    
                </Row>
            </Container>
            </React.Fragment>
        )
    }
}