import React, { Component } from 'react';
import { Container, Header, Form, Button, Dropdown, Input, TextArea } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import API from '../Api';
// private int id;
// private String isbn;
// private String title;
// private List<Author> authors = new ArrayList<>();
// private List<Category> cateries = new ArrayList<>()
// private Publisher publisher;
// private int year;
// private int count;
// private int size;
// private String description;
// private Date addedAt;
class Authorization extends Component {
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

  auth = async e => {
    const { email, password } = this.state;
    if (email === '' || password === '') {
      this.setState({ error: 'Email или Пароль не должны быть пустыми' });
    } else {
      const response = await API.auth(this.state);
      const { ok, data } = response;
      if (ok) {
        localStorage.setItem('isAdmin', data.isAdmin);
        localStorage.setItem('isAuthorized', true);
        this.props.history.push('/books/list');
      } else {
        this.setState({ error: 'Ошибка сервера. Попробуйте позже' });
      }
    }
  };

  render() {
    const { email, password } = this.state;
    const { changeInputValue, auth } = this;
    return (
      <Wrapper text>
        <Header>Авторизация</Header>
        <Form style={{ display: 'flex', flexDirection: 'column' }}>
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
          <Button type="submit" onClick={auth}>
            Submit
          </Button>
          <RegistrationLink to={{ pathname: '/registration' }}>Зарегестрироваться</RegistrationLink>
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
  margin-left: auto;
  margin-top: 30px;
`;
export default Authorization;
