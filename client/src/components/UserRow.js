import React, {Component} from 'react';
import UserAPI from "../api/user";
import {Dropdown} from "semantic-ui-react";
import styled from "styled-components";

export default class UserRow extends Component {
  getUserUrl = () => `/user/${this.props.user.id}`;

  deleteUser = async () => {
    const { user } = this.props;
    const response = await UserAPI.deleteUser(user.id);
    document.location.reload();
  };

  setRole = async (e, data) => {
    const {user} = this.props;

    await UserAPI.editUser(user.id, {...user, role: data.value});
  };

  render() {
    const { user } = this.props;

    const roles = [
      {value: 'USER', text: 'Читатель'},
      {value: 'LIBR', text: 'Библиотекарь'},
      {value: 'ADMIN', text: 'Администратор'}
    ];

    return (
      <tr className="user-row">
        <Cell>{user.realname}&nbsp;
        (<a className="user-edit" href={this.getUserUrl()}>
          {user.username}
        </a>)
        </Cell>
        <Cell>
          Роль: <Dropdown inline options={roles}
                    defaultValue={user.role}
                    onChange={this.setRole}/>
        </Cell>
        <Cell>
          <a className="user-remove" href="#" onClick={this.deleteUser}>Удалить</a>
        </Cell>
      </tr>
    );
  }
}

const Cell = styled.td`
  padding: 0 0 10px 30px;
`;
