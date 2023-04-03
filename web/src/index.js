import React from 'react';
import ReactDOM from 'react-dom/client';
// Bootstrap CSS
import "bootstrap/dist/css/bootstrap.min.css";
// Bootstrap Bundle JS
import "bootstrap/dist/js/bootstrap.bundle.min";
import Home from './components/home/Home';
import Navbar from './components/navbar/Navbar';
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
const date = new Date();
const showTime = date.getHours()
    + ':' + date.getMinutes()
    + ":" + date.getSeconds();

root.render(
    <React.StrictMode>
        <Navbar />
        <Home />
    </React.StrictMode>
);

export { showTime };
