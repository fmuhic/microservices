import './home.css';
import Transactions from '../transactions/Transactions';
import React from 'react';
import { Routes, Route } from 'react-router-dom';

function Home() {
    return (
        <div className="component home">
            <Routes>
                {/* <Route path="/" element={<Home />} /> */}
                <Route path="/transactions" element={<Transactions />} />
                {/* <Route path="/about" element={<About />} /> */}
            </Routes>
        </div>
    );
}

export default Home;
