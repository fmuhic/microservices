import React from "react";
import TableRow from "../tablerow/TableRow";
import TableHead from "../tablehead/TableHead";

const Table = ({ theadData, tbodyData, customClass }) => {
    return (
        <table className={customClass}>
            <thead>
                <tr>
                    {theadData.map((h) => {
                        return <TableHead key={h} item={h} />;
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
