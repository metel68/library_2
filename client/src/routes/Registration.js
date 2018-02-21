import React, { Component } from 'react';
import { Container, Header, Form, Button } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import UserAPI from '../api/user';

class Registration extends Component {
  constructor() {
    super();
    this.state = {
      email: '',
      password: '',
    };
  }

  changeInputValue = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  createNewUser = async e => {
    const { email, password } = this.setState;
    if (email === '' || password === '') {
      this.setState({ error: 'Email или Пароль не должны быть пустыми' });
    } else {
      const response = await UserAPI.registerUser(this.state);
      const { ok, data } = response;

      if (ok) {
        localStorage.setItem('role', data.role);
        localStorage.setItem('isAuthorized', true);
        localStorage.setItem('userId', data.id);
        this.props.history.push('/books/list');
      } else {
        this.setState({ error: 'Не правильные email или пароль' });
      }
    }
  };

  render() {
    const { email, password } = this.state;
    const { changeInputValue, createNewUser } = this;
    return (
      <Wrapper text>
        <Header>Регистрация</Header>
        <Form>
          <Form.Field>
            <label>Email</label>
            <input name="email" onChange={changeInputValue} value={email} placeholder="Email" />
          </Form.Field>
          <Form.Field>
            <label>Пароль</label>
            <input
              name="password"
              type="password"
              onChange={changeInputValue}
              value={password}
              placeholder="Пароль"
            />
          </Form.Field>
          <Button type="submit" onClick={createNewUser}>
            Submit
          </Button>
          <RegistrationLink to={{ pathname: '/' }}>Авторизоваться</RegistrationLink>
        </Form>
      </Wrapper>
    );
  }
}

const Wrapper = styled(Container)`
  margin-top: 50px;
  margin-bottom: 50px;
`;

const RegistrationLink = styled(Link)`
  margin-left: 500px;
  margin-top: 30px;
`;

export default Registration;
