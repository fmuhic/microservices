import React from "react";
import TableRow from "../tablerow/TableRow";
import TableHead from "../tablehead/TableHead";

const Table = ({ theadData, tbodyData }) => {
    return (
        <table>
            <thead>
                <tr>
                    {theadData.map((h) => {
                        return <TableHead key={h.replace(/_/g, ' ')} item={h.replace(/_/g, ' ')} />;
                    })}
                </tr>
            </thead>
            <tbody>
                {tbodyData.map((item) => {
                    return <TableRow key={item.id} data={item} />;
                })}
            </tbody>
        </table>
    );
};

export default Table;
