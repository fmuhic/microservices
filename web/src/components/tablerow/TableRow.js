import React from "react";

const TableRow = ({ data }) => {
    let rowContent = Object.values(data).map(item => {
        return <td>{item}</td>
    })

    return (
        <tr>
            {rowContent}
        </tr>
    );
};

export default TableRow;