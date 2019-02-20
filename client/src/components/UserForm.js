import React, {Component} from 'react';
import {
  Form,
  Button,
} from 'semantic-ui-react';
import styled from 'styled-components';
import UserAPI from "../api/user";

export default class UserForm extends Component {
  constructor() {
    super();

    this.state = {
      user: {
        realname: '',
        username: '',
        password: null,
        role: 'USER',
      },
      showForm: false,
    }
  }

  hideEditForm = () => this.setState({showForm: false});

  showEditForm = () => {
    const {user} = this.props;

    this.setState({user, showForm: true});
  };

  saveUser = async () => {
    const {user} = this.state;
    const response = await UserAPI.editUser(user.id, user);
    const {ok, data, error} = response;

    if (ok) {
      this.hideEditForm();
    } else {
      this.setState({error});
    }
  };

  changeInputValue = e => {
    const {name, value} = e.target;
    const {user} = this.state;

    user[name] = value;
    this.setState({user}); // triggers update event
  };

  EditForm = ({user}) => {
    const {changeInputValue} = this;

    return (
      <Form>
        <Form.Field>
          <label>ФИО:</label>
          <input
            name="realname"
            defaultValue={user.realname}
            onChange={changeInputValue}
            placeholder="ФИО"
          />
        </Form.Field>
        <Form.Field>
          <label>Пароль:</label>
          <input
            name="password"
            onChange={changeInputValue}
            placeholder="123456 ;)"
          />
        </Form.Field>
        <Form.Field>
          <Button type="submit" onClick={this.saveUser}>
            Сохранить
          </Button>
        </Form.Field>
        <Form.Field>
          <Button type="submit" name="user" onClick={this.hideEditForm}>
            Отменить
          </Button>
        </Form.Field>
      </Form>
    )
  }

  UserContent = ({user, showForm}) => {
    const {EditForm} = this;

    if (!showForm) {
      return (
        <div>
          ФИО: {user.realname}
        </div>
      );
    } else {
      return <EditForm user={user} />
    }
  }

  render() {
    const {user} = this.props;
    const {UserContent} = this;

    return (
      <div>
        <InfoRow>
          <UserContent user={user} showForm={this.state.showForm} />
          <a href="#" onClick={this.showEditForm}>Редактировать</a>
        </InfoRow>
      </div>
    );
  }
}

const InfoRow = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 16px;
`;
