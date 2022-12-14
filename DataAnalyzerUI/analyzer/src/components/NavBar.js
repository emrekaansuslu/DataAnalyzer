import React from "react";
import image from '../logo.jpeg'
const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <a className="navbar-brand" href="#">
        MIDAS
      </a>
      <button
        className="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarNavDropdown">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <a className="nav-link" href="./component/StatusInfoList">
              Home <span className="sr-only">(current)</span>
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/StatusInfoList">
              Info Table
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/Charts">
              Detail Analyze
            </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/AutoChartMaker">
              Auto Chart Maker
            </a>
          </li>

        </ul>
      </div>
    </nav>
  );
};

export default NavBar;