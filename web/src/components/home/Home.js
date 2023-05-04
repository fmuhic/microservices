import './home.css';
import Transactions from '../transactions/Transactions';
import React from 'react';

function Home() {
    return (
        <div className="component home">
            {/* <ActivityGraph /> */}
            <Transactions />
        </div>
    );
}

export default Home;
