import React, { useState } from "react";

import Button from '@material-ui/core/Button';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';

import api from '../../services/api'
import * as auth from '../../services/auth';
import { useHistory } from "react-router-dom";


const useStyles = makeStyles((theme) => ({
    container: {
      padding: theme.spacing(3),
    },
  })
);
const defaultValues = {
    email: "",
    password: "",
}
const LoginPage = () => {
    const classes = useStyles();
    let history = useHistory();

    const [credentials, setCredentials] = useState(defaultValues);

    const handleSubmit = async (e) => {
        e.preventDefault();

        await api.post("/login", credentials)
            .then( res => {
                const token = res.data.Token;
                auth.login(token);       
                history.push("/")         
            })
            .catch(err => {
                alert("deu merda")
                console.log(err.response.data);
            })
    }
  
    return (
        <Container className={classes.container} maxWidth="xs">
        <form>
          <Grid container spacing={3}>
            <Grid item xs={12}>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <TextField 
                    fullWidth 
                    label="Email" 
                    name="email" 
                    size="small" 
                    variant="outlined" 
                    value={credentials.email}
                    onChange={ e => setCredentials({...credentials, email: e.target.value})}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Password"
                    name="password"
                    size="small"
                    type="password"
                    variant="outlined"
                    value={credentials.password}
                    onChange={ e => setCredentials({...credentials, password: e.target.value})}
                  />
                </Grid>
              </Grid>
            </Grid>
            <Grid item xs={12}>
              <Button color="secondary" fullWidth type="submit" variant="contained" onClick={handleSubmit}>
                Log in
              </Button>
            </Grid>
          </Grid>
        </form>
      </Container>
    );
  };

export default LoginPage;