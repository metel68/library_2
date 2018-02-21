import React, {Component} from 'react';
import UserAPI from "../api/user";

export default class UserRow extends Component {
  getUserUrl = () => `/user/${this.props.user.id}`;

  deleteUser = async () => {
    const { user } = this.props;
    const response = await UserAPI.deleteUser(user.id);
    document.location.reload();
  };

  setRole = async () => {

  };

  render() {
    const { user } = this.props;

    return (
      <tr className="user-row">
        <td>{user.realname}&nbsp;
        (<a className="user-edit" href={this.getUserUrl()}>
          {user.username}
        </a>)
        </td>
        <td>
          <a className="user-roles" href="#" onClick={this.setRole}>Изменить роль</a>
        </td>
        <td>
          <a className="user-remove" href="#" onClick={this.deleteUser}>Удалить</a>
        </td>
      </tr>
    );
  }
}