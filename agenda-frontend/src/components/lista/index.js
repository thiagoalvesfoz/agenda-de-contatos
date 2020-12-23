import React, { useState } from 'react';
import { DataGrid } from '@material-ui/data-grid';

import DialogItem from '../DialogItem'

const columns = [
  { field: 'titulo', headerName: 'Título', width: 300 },
  { field: 'email', headerName: 'Email', width: 400 },
  {
    field: 'telefone',
    headerName: 'Telefone',
    width: 300,
  },
];

const rows = [
  { id: 1, titulo: 'Snow', email: 'Jon', telefone: 35 },
  { id: 2, titulo: 'Lannister', email: 'Cersei', telefone: 42 },
  { id: 3, titulo: 'Lannister', email: 'Jaime', telefone: 45 },
  { id: 4, titulo: 'Stark', email: 'Arya', telefone: 16 },
  { id: 5, titulo: 'Targaryen', email: 'Daenerys', telefone: null },
  { id: 6, titulo: 'Melisandre', email: null, telefone: 150 },
  { id: 7, titulo: 'Clifford', email: 'Ferrara', telefone: 44 },
  { id: 8, titulo: 'Frances', email: 'Rossini', telefone: 36 },
  { id: 9, titulo: 'Roxie', email: 'Harvey', telefone: 65 },
];

const handleClickRow = ({row}) => console.log(row);

export default function DataTable() {

  const [open, setOpen] = useState(false);

  const handleClick = () => {
    setOpen(!open);
  };

  return (
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid 
        rows={rows} 
        columns={columns} 
        pageSize={5} 
        checkboxSelection={false} 
        onRowClick={handleClick}
        />
        <DialogItem handleClick={handleClick}/>
    </div>
  );
}