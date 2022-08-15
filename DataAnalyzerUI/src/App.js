
import './App.css';
import StatusInfoList from './components/StatusInfoList';
import HomePage from './components/NavBar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavBar from './components/NavBar';
import Charts from './components/Charts';
import MidasChartMaker from './components/MidasChartMaker';
import MidasMainPage from './components/MidasMainPage';

function App() {
  let component
  switch (window.location.pathname) {
    case "/":
      component = <MidasMainPage/>
      break;
    case "/StatusInfoList":
      component = <StatusInfoList/>
      break;
    case "/Charts":
        component = <Charts />
        break;
    case "/AutoChartMaker":
        component = <MidasChartMaker />
        break;
    default:
      break;
  }
  return (
    <div className="App">
      <NavBar/>
      {component}
    </div>
    
  );
}


export default App;
