import React, { Component } from 'react';
import { Container, Header, Form, Button, Dropdown, Input, TextArea } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Author from '../components/Author';
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
class CreateBook extends Component {
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
      const response = await API.registerUser(this.state);
      const { ok, data } = response;
      console.log(response);
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
        </Form>
      </Wrapper>
    );
  }
}

const Wrapper = styled(Container)`
  margin-top: 50px;
  margin-bottom: 50px;
`;

export default CreateBook;
