import React, { useState } from 'react';
import Table from '../table/Table';

function Transactions() {
    const url = 'http://localhost:8080/transaction';
    const [data, setData] = useState([])
    const [columns, setColumns] = useState([])

    const fetchInfo = () => {
        return fetch(url)
            .then((res) => res.json())
            .then((data) => {
                setData(data)
                setColumns(Object.keys(data[0]))
            })
    }

    React.useEffect(() => {
        fetchInfo();
    }, [])

    return (
        <div>
            <Table theadData={columns} tbodyData={data} />
        </div>
    );
};

export default Transactions;