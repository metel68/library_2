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
      showForm: false,
    }
  }

  hideEditForm = () => {
    this.setState((prevState) => ({
      ...prevState,
      showForm: false
    }))
  }

  showEditForm = () => {
    this.setState((prevState) => ({
      ...prevState,
      showForm: true
    }))
  }

  saveUser = async () => {
    const {user} = this.props;
    const response = await UserAPI.editUser(user.id, user);
    const {ok, data, error} = response;

    if (ok) {
      this.hideEditForm();
    } else {
      this.setState({error});
    }
  }

  EditForm = ({user}) => {
    return (
      <Form>
        <Form.Field>
          <label>ФИО:</label>
          <input
            name="realname"
            value={user.realname}
            placeholder="ФИО"
          />
        </Form.Field>
        <Form.Field>
          <Button type="submit" onClick={this.saveUser}>
            Добавить
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
        <a href="#" onClick={this.showEditForm}>Редактировать</a>
        <InfoRow>
          <UserContent user={user} showForm={this.state.showForm} />
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
