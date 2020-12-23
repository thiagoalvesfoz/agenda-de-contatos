import React from 'react';
import { makeStyles } from '@material-ui/core/styles';

import Header from '../../components/header'
import Lista from '../../components/lista'

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
}));

export default function Schedule() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
        <Header />
        <main className={classes.content}>
          <Lista >

          </Lista>
        </main>
    </div>
  );
}
