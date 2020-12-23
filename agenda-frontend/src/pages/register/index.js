import React, { useState } from "react";

import Button from '@material-ui/core/Button';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';

import api from '../../services/api'
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
    passwordConfimation: ""
}
const Register = () => {
    const classes = useStyles();
    let history = useHistory();


    const [register, setRegister] = useState(defaultValues);
    const [errors, setErrors] = useState({});

    const handleSubmit = async (e) => {
        
        setErrors({});
        e.preventDefault();

        if(register.password !== register.passwordConfimation){
            setErrors({
                password: "As senhas não coincidem",
                passwordConfimation: "As senhas não coincidem"
            })
            return false;
        }

        await api.post("/users", register)
            .then( data => {
                history.push('/login')
            })
            .catch(err => {          
                const arr = err.response.data.fields;
                let erros = {}

                arr.forEach(item => {
                    if(item.name === "email")
                        erros = {...erros, email: item.message}
                    
                    if(item.name === "password")
                        erros = {...erros, password: item.message}

                    if(item.name === "passwordConfimation")
                        erros = {...erros, passwordConfimation: item.message}
                })
                setErrors(erros);
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
                    error={!!errors.email}
                    helperText={errors.email}
                    fullWidth 
                    label="Email" 
                    name="email" 
                    size="small" 
                    variant="outlined" 
                    value={register.email}
                    onChange={ e => setRegister({...register, email: e.target.value})}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    error={!!errors.password}
                    helperText={errors.password}
                    label="Senha"
                    name="password"
                    size="small"
                    type="password"
                    variant="outlined"
                    value={register.password}
                    onChange={ e => setRegister({...register, password: e.target.value})}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    error={!!errors.passwordConfimation}
                    helperText={errors.passwordConfimation}
                    label="Confirmar senha"
                    name="Confirm password"
                    size="small"
                    type="password"
                    variant="outlined"
                    value={register.passwordConfimation}
                    onChange={ e => setRegister({...register, passwordConfimation: e.target.value})}
                  />
                </Grid>
              </Grid>
            </Grid>
            <Grid item xs={12}>
              <Button color="secondary" fullWidth type="submit" variant="contained" onClick={handleSubmit}>
                Registrar
              </Button>
            </Grid>
          </Grid>
        </form>
      </Container>
    );
  };

export default Register;